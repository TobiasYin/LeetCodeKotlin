package answer.leetcode

class Solution50 {
    fun myPow(x: Double, n: Int): Double {
        if(x==1.0) return 1.0
        if(x==-1.0) return if(n%2==0) 1.0 else -1.0
        val flag = n < 0
        val x1 = if(flag) 1.0/x else x
        val n1 = if(flag) -(n.toLong()) else n.toLong()
        var result = 1.toDouble()
        for (i in 1..n1) {
            result *= x1
                if(result == 0.0) break
        }
        return result
    }
}

fun main(args: Array<String>) {
    val solution50 = Solution50()
    val t1 = System.nanoTime()
    println(solution50.myPow(-1.0,-2147483647))
    val t2 = System.nanoTime()
    println((t2-t1).toDouble()/1000000000.toDouble())
    val x = -2147483648
    println(x)
}