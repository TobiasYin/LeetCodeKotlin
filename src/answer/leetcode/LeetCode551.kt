package answer.leetcode

class Solution551 {
    fun checkRecord(s: String): Boolean {
        if (s.count { it == 'A' } > 1) {
            return false
        } else if (s.indexOf("LLL") != -1) {
            return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution551 = Solution551()
    println(solution551.checkRecord("PPLLAL"))
}