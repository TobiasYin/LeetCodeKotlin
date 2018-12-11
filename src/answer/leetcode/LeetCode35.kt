package answer.leetcode

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()){
            return 0
        }
        if(nums[0]>target){
            return 0
        }
        if(nums.last()<target){
            return nums.size
        }
        for ((index,value) in nums.withIndex()){
            if (value == target){
                return index
            }
            if (value < target && index < nums.size-1 && nums[index+1]>target){
                return index+1
            }
        }
    return 0
    }
}