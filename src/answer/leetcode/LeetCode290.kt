package answer.leetcode

class Solution290 {
    fun wordPattern(pattern: String, str: String): Boolean {
        val map = hashMapOf<Char, String>()
        val l = str.split(" ")
        for ((index, item) in l.withIndex()) {
            if (index >= pattern.length) return false
            if (map.containsKey(pattern[index]) && map[pattern[index]] != item) {
                return false
            }
            for (i in map.keys){
                if (i != pattern[index] && map[i] == item)
                    return false
            }
            map[pattern[index]] = item
        }
        return l.size == pattern.length
    }
}