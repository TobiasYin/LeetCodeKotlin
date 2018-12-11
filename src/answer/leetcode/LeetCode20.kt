package answer.leetcode

class Solution20 {
    fun isValid(s: String): Boolean {
        val left = "[{("
        val right = "]})"
        val stack = Stack<Char>()
        for (i in s) {
            if (i in left) {
                stack.push(i)
            } else if (i in right) {
                if (stack.empty) {
                    return false
                }
                if (when (stack.pop()) {
                        '(' -> i == ')'
                        '[' -> i == ']'
                        '{' -> i == '}'
                        else -> false
                    }
                ) {
                    continue
                } else {
                    return false
                }
            } else {
                return false
            }
        }
        if (stack.empty) {
            return true
        }
        return false
    }
}

class Stack<E>{
    private var data = arrayOfNulls<Any>(10) as Array<E>
    private var size = 0
    val empty: Boolean
        get() = size == 0

    private fun resize(length: Int) {
        val newData = arrayOfNulls<Any>(length) as Array<E>
        for (i in 0 until size) {
            newData[i] = data[i]
        }
        data = newData
    }

    fun push(element: E) {
        if (size == data.size) resize(size * 2)
        data[size++] = element
    }

    fun pop(): E {
        val temp = data[--size]
        if (size < data.size / 4 && data.size / 2 != 0) resize(data.size / 2)
        return temp
    }

    fun peek(): E = data[size - 1]
}