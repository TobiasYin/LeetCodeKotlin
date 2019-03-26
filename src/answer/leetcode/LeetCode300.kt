package answer.leetcode

class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        var result = 0
        var now = 0
        var last = nums[0]
        for (i in 1..nums.lastIndex){
            if (nums[i] > last){
                if (now == 0){
                    now += 2
                }else{
                    now += 1
                }
            }else{
                if (now > result){
                    result = now
                }
                now = 0
            }
            last = nums[i]
        }
        return result
    }
}

fun main(args: Array<String>) {
    val solution300 = Solution300()
    println(solution300.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}

//理解错题意,待解决