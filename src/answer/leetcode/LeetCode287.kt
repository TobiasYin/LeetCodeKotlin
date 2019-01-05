package answer.leetcode

class Solution287 {
    fun findDuplicate(nums: IntArray): Int {
        var last = 0
        for (i in nums.sorted()){
            if (i == last){
                return i
            }else{
                last = i
            }
        }
        return last
    }
}

fun main(args: Array<String>) {
    val solution287 = Solution287()
    println(solution287.findDuplicate(intArrayOf(1,3,2,4,1)))
}