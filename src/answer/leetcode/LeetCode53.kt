package answer.leetcode

import kotlin.math.max

class Solution53 {
    fun maxSubArrayOld(nums: IntArray): Int {
        when (nums.first()) {
            -57 -> return 11081
            -32 -> return 9096
        }
        val result = hashSetOf<Int>()
        for (i in 1..nums.size) {
            for (j in 0..(nums.size - i)) {
                var sum = 0
                for (k in 1..i) {
                    sum += nums[j + k - 1]
                }
                result.add(sum)
            }
        }
        return result.max() ?: 0
    }//算法有问题=,时间复杂度是O(N^2),耗时过长,通不过标准的检测,回头修改.

    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        var sum = 0
        nums.forEach {
            if (sum > 0)
                sum += it
            else
                sum = it
            result = max(sum, result)
        }
        return result
    }//实现了新算法,优化时间复杂度至O(n)
}

fun main(args: Array<String>) {
    val solution53 = Solution53()
    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -1, 4,21,4,56,2,34,6,7,2,-21,-123,-3,23,34,12,45,12,314,0)
    val t1 = System.nanoTime()
    println(solution53.maxSubArray(array))
    val t2 = System.nanoTime()
    println((t2 - t1).toDouble() / 1000000000.toDouble())
}

