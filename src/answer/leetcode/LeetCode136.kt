package answer.leetcode

class Solution136 {
    fun singleNumber(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        nums.forEach {
            if (it !in set) set.add(it)
            else set.remove(it)
        }
        return set.first()
    }
}
//使用了额外的空间,题的要求是不使用额外空间,最快的实现使用异或实现的,等补习了计算机基础在来看吧.

fun main(args: Array<String>) {
    val array = intArrayOf(4,1,2,1,2)
    val solution136 = Solution136()
    println(solution136.singleNumber(array))
}