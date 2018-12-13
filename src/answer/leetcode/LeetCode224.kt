package answer.leetcode

import java.lang.IndexOutOfBoundsException
import java.lang.Math.pow
import kotlin.IllegalArgumentException

class Solution224 {
    fun calculate(s: String): Int {
        val result = parseList(parseToList(s))
        return (result.eval() as Value).value
    }

    private fun parseToList(s1: String): List<Any> {
        val s = s1.filter { it != ' ' }
        val array = arrayListOf<Any>()
        for ((index, item) in s.withIndex()) {
            if (index == 0) {
                if (item in '0'..'9') {
                    array.add(item.toInt() - 48)
                } else {
                    array.add(item)
                }
            } else if (array.last() is Int && item in '0'..'9') {
                array[array.lastIndex] = (array.last().toString() + item.toString()).toInt()
            } else if (item in '0'..'9') {
                array.add(item.toInt() - 48)
            } else {
                array.add(item)
            }
        }
        for ((index, item) in array.withIndex()) {
            if (item is Int) {
                array[index] = Value(item)
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
            return eval{valueX, valueY -> Value(pow((valueX.eval() as Value).value.toDouble(),(valueY.eval() as Value).value.toDouble()).toInt()) }
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

    class Value(val value: Int) : Node {
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
            if (temp == 0) {
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
    val solution224 = Solution224()
//    val s1 = Solution224.Sum(Solution224.Value(3), Solution224.Value(4))//7
//    val s2 = Solution224.Sum(Solution224.Value(6), Solution224.Value(5))//11
//    val s3 = Solution224.Sum(s1, Solution224.Value(5))//12
//    val s4 = Solution224.Sum(s3, s2)//23
//    val m1 = Solution224.Minus(s1, s4)//-16
//    val m2 = Solution224.Minus(m1, Solution224.Value(5))//-21
//    val m3 = Solution224.Minus(m2, s1)//-28
//    println(m3.eval())
//    val stack = Solution224.Stack<Int>()
//    for (i in 1..100) {
//        stack.push(i)
//    }
//    println("stack : ${stack.array.joinToString(" ")}")
//
//    for (i in 1..100) {
//        println(stack.pop())
//    }
//    println('0'.toInt() - 48)
    println(solution224.calculate("2*2^3"))
    println(timeTest(10000) { solution224.calculate("1*2") })
//    println(listOf(1, 2, 3, 4, 5, 6).subList(2, 5))
}
// 为什么写这么多呢? 这道题只用建构一个+,-运算符, 但是这样这样写可以构建一个计算器框架,只要想,可以往里面添加任何运算符,包括乘除,次方之类的.当然, 这个框架还差一个很重要的部分, 优先级, 等下次想真正做个完整计算器时,在在这基础上添加吧.

// 更新,顺便实现了 * /