package answer.leetcode

class Solution202 {
    fun isHappy(n: Int): Boolean {
        val set = hashSetOf(n)
        var num = n
        while (num != 1) {
            num = num.toString().split("").asSequence().filter { it != "" }.map { it.toInt() * it.toInt() }.sum()
            if (num in set)
                return false
            set.add(num)
        }
        return true
    }
}