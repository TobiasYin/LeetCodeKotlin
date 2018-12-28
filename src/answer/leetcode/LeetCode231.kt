package answer.leetcode

class Solution231 {
    fun isPowerOfTwo(n: Int): Boolean {
        if( n == 0 || n == -2147483648 ) return false
        return n and (n-1) == 0
    }
}

fun main(args: Array<String>) {
    val solution231 = Solution231()
    println(solution231.isPowerOfTwo(3))
    println(2 and 1)
    println(-2147483648 and 2147483647)
}