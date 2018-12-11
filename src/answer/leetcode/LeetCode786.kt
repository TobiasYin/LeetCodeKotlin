package answer.leetcode

class Solution786 {
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        val set = hashSetOf<Pair<Pair<Int, Int>, Double>>()
        for (i in 0 until A.size) {
            for (j in i until A.size) {
                set.add((A[i] to A[j]) to A[i].toDouble() / A[j].toDouble())
            }
        }
        val list = set.toList().sortedBy { it.second }
        return list[K].first.toList().toIntArray()
    }
}

//待解决