package answer.leetcode

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        val s1 = s.toSet()
        val t1 = t.toSet()
        if (t1 != s1) {
            return false
        }
        for (i in t1) {
            if (s.count { it == i } != t.count { it == i })
                return false
        }
        return true
    }
}