package answer.leetcode

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        val res = arrayListOf<Int>()
        for (i in nums1) {
            if (!map.containsKey(i))
                map[i] = 0
            else map[i] = map[i]!! + 1
        }
        for (num in nums2) {
            if (map.containsKey(num)) {
                if (map[num]!! >= 0) {
                    res.add(num)
                    map[num] = map[num]!! - 1
                }
            }
        }
        return res.toIntArray()
    }
}