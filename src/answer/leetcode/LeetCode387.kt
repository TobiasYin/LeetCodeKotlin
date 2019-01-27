package answer.leetcode

class Solution387 {
    fun firstUniqChar(s: String): Int {
        val count = IntArray(26)
        for (i in s) count[i - 'a']++
        for ((index,item ) in s.withIndex()) if (count[item - 'a'] == 1) return index
        return -1
    }
}