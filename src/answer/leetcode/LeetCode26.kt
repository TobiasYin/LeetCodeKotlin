package answer.leetcode

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        var length = nums.size
        if (length == 0) {
            return 0
        }
        var temp = nums[0]
        var i = 1
        while (i < length) {
            if (nums[i] == temp) {
                for (j in i until length - 1) nums[j] = nums[j + 1]
                length--
            } else {
                temp = nums[i]
                i++
            }
        }
        return length
    }
}