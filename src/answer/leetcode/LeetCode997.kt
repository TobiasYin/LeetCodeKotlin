package answer.leetcode

class Solution997 {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val trustNum = Array<IntArray>(N) { intArrayOf(0, 0) }
        for (i in trust) {
            trustNum[i[0] - 1][0] += 1
            trustNum[i[1] - 1][1] += 1
        }
        for ((index, item) in trustNum.withIndex()) {
            if (item[0] == 0 && item[1] == N - 1)
                return index + 1
        }
        return -1
    }
}

fun main() {
    val s = Solution997()
    println(
        s.findJudge(
            4,
            arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(4, 3))
        )
    )
}