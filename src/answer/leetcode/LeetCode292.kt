package answer.leetcode

class Solution292 {
    fun canWinNim(n: Int): Boolean {
//        if (n <= 3)
//            return true
//        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3)
        return n % 4 != 0
    }
}

fun main(args: Array<String>) {
    val solution292 = Solution292()
    println(solution292.canWinNim(50))
}