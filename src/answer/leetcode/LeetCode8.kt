package answer.leetcode

import java.lang.Math

class Solution8 {
    fun myAtoi(str: String): Int {
        val res = StringBuilder()
        for ((index,char) in str.trim().withIndex()){
            if (!(char in '0'..'9' || (index == 0 && (char == '-' || char == '+'))))
                break
            res.append(char)
        }
        var neg = false
        var r = 0.0
        res.toString().forEachIndexed { index, c ->
            if (index == 0 && c == '-') neg = true
            else if (c != '+') {
                r += (c - '0') * Math.pow(10.0, (res.length - 1 - index).toDouble())
                if (r > Int.MAX_VALUE)
                    return if (neg) Int.MIN_VALUE else Int.MAX_VALUE
            }
        }
        return if (neg) if (-r == Int.MIN_VALUE.toDouble()) Int.MIN_VALUE else (-r).toInt() else r.toInt()
    }
}

fun main() {
    val s = Solution8()
    println(s.myAtoi("20000000000000000000"))
}