package answer.leetcode

class Solution268 {
    fun missingNumber(nums: IntArray): Int {
        val set = nums.toSet()
        for( i in 0..set.size ){
            if(i !in set){
                return i
            }
        }
        return 0
    }
}