package answer.leetcode

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow


class Solution233 {
    fun countDigitOne(n: Int): Int {
        var result = 0L
        val len = n.toString().length
        for (i in 0 until len) {
            result += ((n / 10.0.pow(i + 1).toLong()) * 10.0.pow(i)).toLong() + min(max(n % 10.0.pow(i + 1).toLong() - 10.0.pow(i).toLong() + 1L, 0L), 10.0.pow(i).toLong())
        }
        return result.toInt()
    }
}

fun main(args: Array<String>) {
    val solution233 = Solution233()
    println(solution233.countDigitOne(13))
    println(solution233.countDigitOne(824883294))
}