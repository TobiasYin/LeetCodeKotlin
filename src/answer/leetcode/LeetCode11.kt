package answer.leetcode

import kotlin.math.min

//class Solution11 {
//    fun maxArea(height: IntArray): Int {
//        var max = 0
//        for (i in 0 until height.lastIndex) {
//            for (j in i + 1..height.lastIndex) {
//                val space = min(height[i], height[j]) * (j - i)
//                if (space > max) max = space
//            }
//        }
//        return max
//    }
//}

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var start = 0
        var end = height.lastIndex
        while (start != end) {
            val temp =
                if (height[start] > height[end]) height[end] * ((end--) - start) else height[start] * (end - (start++))
            if (temp > max) max = temp
        }
        return max
    }
}

fun main() {
    val s = Solution11()
    println(s.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}