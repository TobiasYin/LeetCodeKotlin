package answer.leetcode

class Solution4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val longLen = if (nums1.size>nums2.size) nums1 else nums2
        val shortLen = if (nums1.size<=nums2.size) nums1 else nums2
        val nums = arrayListOf<Int>()
        nums.addAll(longLen.toList())
        var index = 0
        var flag = false
        for(i in 0..(shortLen.size-1)){
            if(flag) break
            for(j in index..(nums.size - 1)){
                if (nums[j]>shortLen[i]){
                    nums.add(j,shortLen[i])
                    index = j
                    break
                }
                if (j == nums.size-1){
                    nums.addAll(shortLen.slice(i..(shortLen.size-1)))
                    flag = true
                    break
                }
            }
        }

        if (nums.size%2==0){
            return (nums[nums.size/2-1].toDouble()+nums[nums.size/2].toDouble())/2
        }else{
            return nums[(nums.size-1)/2].toDouble()
        }
    }
}