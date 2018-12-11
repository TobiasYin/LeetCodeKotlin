package answer.leetcode

class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var cursor = nums.size - 1
        var i = 0
        while (i <= cursor) {
            if (nums[i] == `val`) nums[i--] = nums[cursor--]
            i++
        }
        return cursor + 1
    }
}

fun main(args: Array<String>) {
    val solution27 = Solution27()
    val nums = intArrayOf(1)
    val len = solution27.removeElement(nums,1)
    for (i in 0 until len) {
        print(nums[i])
    }
}