package answer.leetcode

import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.StringBuilder
import kotlin.IllegalArgumentException

class Calculator {
    fun calculate(s: String): Double {
        try {
            val result = parseList(parseToList(s))
            return (result.eval() as Value).value
        }catch (e:Exception){
            throw IllegalArgumentException("Unexpected Expression")
        }
    }

    private fun parseToList(s1: String): List<Any> {
        val s = s1.filter { it != ' ' }
        val array = arrayListOf<Any>()
        var index = 0
        label@ while (index < s.length) {
            if (index == 0 && (s[index] == '+' || s[index] == '-')) {
                val num = StringBuilder(s[index].toString())
                var i = s[++index]
                while (i in '0'..'9' || i == '.') {
                    num.append(i)
                    if (index + 1 < s.length) {
                        i = s[++index]
                    }
                }
                array.add(num.toString().toDouble())
            }
            val item = s[index]
            if (index == 0) {
                if (item in '0'..'9') {
                    array.add((item.toInt() - 48))
                } else {
                    array.add(item)
                }
            } else if (array.last() is Int && item in '0'..'9') {
                array[array.lastIndex] = (array.last().toString() + item.toString()).toInt()
            } else if (item in '0'..'9') {
                array.add(item.toInt() - 48)
            } else if (item == '.') {
                val num = StringBuilder(array[array.lastIndex].toString())
                num.append('.')
                var i = s[++index]
                var flag = false
                while (i in '0'..'9') {
                    num.append(i)
                    if (index + 1 < s.length)
                        i = s[++index]
                    else {
                        flag = true
                        break
                    }
                }
                array[array.lastIndex] = num.toString().toDouble()
                if (flag) {
                    break@label
                }
                index--
            } else {
                array.add(item)
            }
            index++
        }
        for ((index0, item) in array.withIndex()) {
            if (item is Number) {
                array[index0] = Value(item.toDouble())
            }
        }
        return array
    }

    private fun parseList(array0: List<Any>): Node {
        if (array0.size == 1) {
            if (array0[0] is Node)
                return array0[0] as Node
            else
                throw IllegalArgumentException("Illegal Operate")
        }
        val stack = Stack<Int>()
        val nodeStack = Stack<Node>()
        val array = mutableListOf<Any>()
        array.addAll(array0)
        if (array[0] == '+') {
            array.removeAt(0)
        } else if (array[0] == '-') {
            array.add(0, Value(0.0))
        }
        var index = 0
        while (index < array.size) {
            val item = array[index]
            when (item) {
                '(' -> stack.push(index)
                ')' -> {
                    val index0 = try {
                        stack.pop()
                    } catch (e: IndexOutOfBoundsException) {
                        throw IllegalArgumentException("Illegal )")
                    }

                    val node = parseList(array.subList(index0 + 1, index))
                    for (i in index0..index) {
                        array.removeAt(index0)
                        index--
                    }
                    array.add(index0, node)
                }
            }
            index++
        }
        if (!stack.empty) {
            throw IllegalArgumentException("Illegal (")
        }

        index = 0
        try {
            while (index < array.size) {
                val item = array[index]
                if (item == '^') {
                    val nextItem = array[index + 1]
                    if (nextItem !is Node) {
                        throw IllegalArgumentException("Illegal Operate")
                    }
                    val lastItem = array[index - 1]
                    if (lastItem !is Node) {
                        throw IllegalArgumentException("Illegal Operate")
                    }
                    val node = Pow(lastItem, nextItem).eval()
                    for (i in 1..3) array.removeAt(index - 1)
                    array.add(--index, node)
                }
                index++
            }
            index = 0
            while (index < array.size) {
                val item = array[index]
                when (item) {
                    '*' -> {
                        val nextItem = array[index + 1]
                        if (nextItem !is Node) {
                            throw IllegalArgumentException("Illegal Operate")
                        }
                        val lastItem = array[index - 1]
                        if (lastItem !is Node) {
                            throw IllegalArgumentException("Illegal Operate")
                        }
                        val node = Time(lastItem, nextItem).eval()
                        for (i in 1..3) array.removeAt(index - 1)
                        array.add(--index, node)
                    }
                    '/' -> {
                        val nextItem = array[index + 1]
                        if (nextItem !is Node) {
                            throw IllegalArgumentException("Illegal Operate")
                        }
                        val lastItem = array[index - 1]
                        if (lastItem !is Node) {
                            throw IllegalArgumentException("Illegal Operate")
                        }
                        val node = Div(lastItem, nextItem).eval()
                        for (i in 1..3) array.removeAt(index - 1)
                        array.add(--index, node)
                    }
                }
                index++
            }
            index = 0
            while (index < array.size) {
                val item = array[index]
                when (item) {
                    is Node -> {
                        nodeStack.push(item)
                    }
                    '+' -> {
                        val nextItem = array[++index]
                        if (nextItem !is Node) {
                            throw IllegalArgumentException("Illegal Operator ")
                        }
                        val node = Sum(nodeStack.pop(), nextItem).eval()
                        nodeStack.push(node)
                    }
                    '-' -> {
                        val nextItem = array[++index]
                        if (nextItem !is Node) {
                            throw IllegalArgumentException("Illegal Operator")
                        }
                        val node = Minus(nodeStack.pop(), nextItem).eval()
                        nodeStack.push(node)
                    }
                }
                index++
            }
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalArgumentException("Illegal Operator")
        }


        return nodeStack.pop().eval()
    }

    class Pow(override val valueX: Node, override val valueY: Node) : Node, Operator {
        override fun eval(): Node {
            return eval { valueX, valueY -> Value(Math.pow((valueX.eval() as Value).value, (valueY.eval() as Value).value)) }
        }
    }

    class Time(override val valueX: Node, override val valueY: Node) : Node, Operator {
        override fun eval(): Node {
            return eval { valueX, valueY -> (valueX * valueY) as Value }
        }

        override fun toString(): String {
            return toString('*')
        }
    }

    class Div(override val valueX: Node, override val valueY: Node) : Node, Operator {
        override fun eval(): Node {
            return eval { valueX, valueY -> (valueX / valueY) as Value }
        }

        override fun toString(): String {
            return toString('/')
        }
    }

    class Sum(override val valueX: Node, override val valueY: Node) : Node, Operator {

        override fun eval(): Node {
            return eval { valueX, valueY -> (valueX + valueY) as Value }
        }

        override fun toString(): String {
            return toString('+')
        }
    }

    class Minus(override val valueX: Node, override val valueY: Node) : Node, Operator {

        override fun eval(): Node {
            return eval { valueX, valueY -> (valueX - valueY) as Value }
        }

        override fun toString(): String {
            return toString('-')
        }
    }

    class Value(val value: Double) : Node {
        override fun eval(): Node {
            return this
        }

        override operator fun plus(other: Node): Node {
            if (other is Value) return Value(value + other.value)
            else if (other is Operator) return Value(value + (other.eval() as Value).value)
            return this
        }

        override operator fun minus(other: Node): Node {
            if (other is Value) return Value(value - other.value)
            else if (other is Operator) return Value(value - (other.eval() as Value).value)
            return this
        }

        override operator fun times(other: Node): Node {
            if (other is Value) return Value(value * other.value)
            else if (other is Operator) return Value(value * (other.eval() as Value).value)
            return this
        }

        override operator fun div(other: Node): Node {
            val temp = (other.eval() as Value).value
            if (temp == 0.0) {
                throw IllegalArgumentException(" Zero can't be Divided")
            }
            if (other is Value) return Value(value / temp)
            else if (other is Operator) return Value(value / temp)
            return this
        }

        override fun toString(): String {
            return "v: $value"
        }

    }

    interface Node {
        fun eval(): Node
        operator fun plus(other: Node): Node {
            return this.eval() + other.eval()
        }

        operator fun minus(other: Node): Node {
            return this.eval() - other.eval()
        }

        operator fun times(other: Node): Node {
            return this.eval() * other.eval()
        }

        operator fun div(other: Node): Node {
            return this.eval() / other.eval()
        }
    }

    interface Operator {
        val valueX: Node
        val valueY: Node
        fun eval(operate: (Value, Value) -> Value): Node {
            var tempX = valueX.eval()
            var tempY = valueY.eval()
            while (tempX !is Value) {
                tempX = tempX.eval()
            }
            while (tempY !is Value) {
                tempY = tempY.eval()
            }
            return operate(tempX, tempY)
        }

        fun toString(operate: Char): String {
            return "$valueX $operate $valueY"
        }
    }

    class Stack<T>(capacity: Int = 10) {
        var array = arrayOfNulls<Any>(capacity) as Array<T>
        var size = 0
        val empty: Boolean
            get() = size == 0

        private fun resize(length: Int) {
            val temp = arrayOfNulls<Any>(length) as Array<T>
            for (i in 0 until size) {
                temp[i] = array[i]
            }
            array = temp
        }

        fun push(e: T) {
            array[size++] = e
            if (size == array.size) resize(size * 2)
        }

        fun pop(): T {
            val e = array[--size]
            if (size == array.size / 4 && array.size / 2 != 0) resize(array.size / 2)
            return e
        }
    }
}

fun main(args: Array<String>) {
    val calculator = Calculator()
    println(calculator.calculate("-1.2+5.1+7.1*(3+5.4)^2.1+(-3*5)"))
    println(timeTest(10000) { calculator.calculate("-1.2+5.1+7.1*(3+5.4)^2.1+(-3*5)") })//实现约0.0183s
}

// 基于224题实现了一个计算器,支持有理数的+,-,*,/,^运算,支持'(',')',优先级和算数运算相同