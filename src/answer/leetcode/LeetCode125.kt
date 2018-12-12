package answer.leetcode

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val string = s.filter { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' }.toLowerCase()
        println(string)
        return string == string.reversed()
    }
}

fun main(args: Array<String>) {
    val solution125 = Solution125()
    val s = ""
    println(solution125.isPalindrome(s))
}