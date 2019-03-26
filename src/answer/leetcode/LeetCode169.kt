package answer.leetcode

class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        val map = hashMapOf<Int,Int>()
        nums.forEach {
            map[it] = (map[it]?:0) + 1
            if (map[it]!! > nums.size / 2)
                return it
        }
//        nums.toSet().forEach {
//            if(nums.count{i-> i==it} > nums.size/2)
//                return it
//        }
        return -1
    }
}

fun main() {
    val s = Solution169()
    println(s.majorityElement(intArrayOf(1,2,3,2,3,2,1,2,12,2,2,2,2,2,2,2,2)))
}