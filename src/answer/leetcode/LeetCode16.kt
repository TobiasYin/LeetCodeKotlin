package answer.leetcode

import java.lang.Math.abs

class Solution16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val sorted = nums.sorted()
        var sum = 0
        var dis = 1000
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val res = sorted[i] + sorted[j] + sorted[k]
                    if (abs(res - target) < abs(dis)) {
                        sum = res
                        dis = res - target
                    } else if (res - target > abs(dis))
                        break
                }
            }
        }
        return sum
    }
}

fun main() {
    val nums = intArrayOf(1,2,4,8,16,32,64,128)
    val s = Solution16()
    println(s.threeSumClosest(nums, 82))
}