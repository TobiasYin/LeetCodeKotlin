package answer.leetcode

class Solution162 {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1)
            return 0
        for ((index, item) in nums.withIndex()) {
            if (index != 0 && index != nums.lastIndex) {
                if (item > nums[index - 1] && item > nums[index + 1])
                    return index
            }
        }
        return if (nums[0] > nums[nums.lastIndex]) 0 else nums.lastIndex
    }

    fun findPeakElement2(nums: IntArray): Int {
        var left = 0
        var right = nums.size
        var mid = left - (left - right) / 2
        while (left != right && mid - 1>0 && mid + 1 < nums.size) {
            when {
                nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1] -> return mid
                nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1] -> {
                    left = mid + 1
                    mid = left - (left - right) / 2
                }
                nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1] -> {
                    right = mid
                    mid = left - (left - right) / 2
                }
                else -> {
                    mid++
                }
            }
        }
        return if (nums[0] > nums[nums.lastIndex]) 0 else nums.lastIndex
    }
}

fun main() {
    val a = intArrayOf(1,2,3,1)
    val s = Solution162()
    println(s.findPeakElement2(a))
}