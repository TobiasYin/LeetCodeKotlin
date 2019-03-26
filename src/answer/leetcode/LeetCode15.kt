package answer.leetcode

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
//        if (nums.size < 3)
//            return listOf()
//        val set = nums.toSet()
//        if (set.size == 1)
//            if (nums.size>=3&&nums[0] == 0)
//                return listOf(listOf(0,0,0))
//        val res = HashSet<List<Int>>()
//        for (i in 0 until nums.size){
//            for (j in i + 1 until nums.size){
//                val r = nums[i] + nums[j]
//                if (-r in set) {
//                    if (((nums[i] == -r || nums[j] == -r) && nums.count { it == -r } < 2) || (nums[i] == nums[j] && nums.count { it == -r } < 3))
//                        continue
//                    res.add(listOf(nums[i], nums[j], -r).sorted())
//                }
//            }
//        }
//        return res.toList()
        nums.sort()
        val res = HashSet<List<Int>>()
        for (i in 0 until nums.size) {
            if (i - 1 > 0 && nums[i - 1] == nums[i])
                continue
            for (j in i + 1 until nums.size) {
                if (j - 1 > i && nums[j - 1] == nums[j])
                    continue
                val sum = -(nums[i] + nums[j])
                if (nums.binarySearch(sum, j + 1) > 0) {
                    res.add(listOf(nums[i], nums[j], sum))
                }
            }
        }
        return res.toList()
    }
}

fun main() {
    val s = Solution15()
    val list = listOf(-1, 0, 1, 2, -1, -4, -5, 6, 8, 3)
    println(s.threeSum(list.toIntArray()))
}