package answer.leetcode

import java.lang.Math.abs

class Solution29 {
    fun divide(dividend1: Int, divisor1: Int): Int {
        val dividend = abs(dividend1.toLong())
        val divisor = abs(divisor1.toLong())
        val negative = (dividend1 < 0 && divisor1 > 0) || (dividend1 > 0 && divisor1 < 0)
        val map = hashMapOf<Int, Long>()
        for (i in 1..9) {
            var value = 0L
            for (j in 1..i)
                value += divisor
            map[i] = value
        }
        var s = dividend.toString()
        var res = "0"
        var left = 0
        while (s.isNotEmpty()) {
            var flag = true
            for (j in 0 until s.length) {
                val now = s.substring(0..j).toLong()
                var i = 1
                while (i <= 8 && now > map[i]!!) {
                    i += 1
                }
                if (i == 1 && now < map[i]!!) {
                    i = 0
                    if (left != 0) {
                        left--
                    } else {
                        res += 0
                    }
                }
                if (i != 0) {
                    if (map[i]!! == now) {
                        res += i
                        s = s.substring(j + 1)
                    } else {
                        val l = if (i == 9 && map[i]!! < now) {
                            res += i
                            (now - map[i]!!).toString()
                        } else {
                            res += (i - 1)
                            (now - map[i - 1]!!).toString()
                        }
                        s = l + s.substring(j + 1)
                        left = l.length
                    }
                    flag = false
                    break
                }
            }
            if (flag)
                break
        }
        return if (negative) (0 - res.toLong()).toInt() else if (res.toLong() > Int.MAX_VALUE) Int.MAX_VALUE else res.toInt()
    }
}

fun main() {
    val s = Solution29()
    println(s.divide(2147483647, 3))
}