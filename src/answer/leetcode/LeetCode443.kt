package answer.leetcode

class Solution443 {
    fun compress(chars: CharArray): Int {
        var size = chars.size
        if (size == 0 || size == 1) return size
        var i = 1
        var lastChar = chars[0]
        var len = 0
        while (i < size) {
            if (chars[i] == lastChar) {
                len++
            } else {
                if (len != 0) {
                    val charArray = (len+1).toString().toCharArray()
                    for ((index, item) in charArray.withIndex()) {
                        chars[i - len + index] = item
                    }
                    if (len > 1) {
                        move(chars, i - len + charArray.size, len -  charArray.size, size)
                        i = i - len + charArray.size
                        size = size - len + charArray.size
                    }
                }
                len = 0
                lastChar = chars[i]
            }
            i++
        }
        if (len != 0) {
            val charArray = (len+1).toString().toCharArray()
            for ((index, item) in charArray.withIndex()) {
                chars[i - len + index] = item
            }
            if (len > 1) {
                move(chars, i - len + charArray.size, len -  charArray.size, size)
                size = size - len + charArray.size
            }
        }
        return size
    }

    private fun move(chars: CharArray, index: Int, size: Int, len: Int) {
        var i = index
        while (i + size < len) {
            chars[i] = chars[i + size]
            i++
        }
    }
}

fun main(args: Array<String>) {
    val solution443 = Solution443()
    val chars = charArrayOf('b','b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c')
    val size = solution443.compress(chars)
    println(size)
    println(chars.slice(0 until size))
    println(timeTest(100000) { charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c') })
}