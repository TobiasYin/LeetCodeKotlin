package answer.leetcode

class Solution364 {
    fun isPerfectSquare(num: Int): Boolean {
        if (num < 0) return false
        var numChange = num
        var counter = 1
        while (true){
            numChange /= 2
            counter *= 2
            if (counter >= numChange){
                break
            }
        }
        for (i in numChange..counter){
            if (i*i == num){
                return true
            }
        }
        return false
    }
}

fun main(args: Array<String>) {
    val solution364 = Solution364()
    println(solution364.isPerfectSquare(14))
    println(solution364.isPerfectSquare(16))
    println(solution364.isPerfectSquare(0))
    println(solution364.isPerfectSquare(20))
    println(solution364.isPerfectSquare(25))
    println(solution364.isPerfectSquare(1))
    println(solution364.isPerfectSquare(-1))
    println(solution364.isPerfectSquare(-4))
}