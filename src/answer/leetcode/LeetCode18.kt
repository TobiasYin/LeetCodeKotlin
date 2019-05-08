package answer.leetcode

class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val sorted = nums.sorted()
        val set = nums.toSet()
        val res = hashSetOf<List<Int>>()
        for (i in 0 until sorted.size)
            for (j in i + 1 until sorted.size)
                for (k in j + 1 until sorted.size) {
                    val temp = target - (sorted[i] + sorted[j] + sorted[k])
                    val tempRes = listOf(sorted[i], sorted[j], sorted[k], temp).sorted()
                    if (temp in set && tempRes.count{it == temp} <= sorted.count{it == temp})
                        res.add(tempRes)
                }
        return res.toList()
    }
}

fun main() {
    val s = Solution18()
    val res = s.fourSum(intArrayOf(1, 0, -1, 0, -2, 2),0)
    println(res.joinToString("\n",prefix = "[", postfix = "]") { it.joinToString(" ") })
}