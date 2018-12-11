package answer.leetcode

import java.lang.Math.pow

class Solution69 {
    fun mySqrt(x: Int): Int {
        if(x==1) return 1
        var max=1L
        var i = 0
        while (max<x){
            max*=100
            i++
        }
        println(i)
//        val temp = pow(10.toDouble(),i.toDouble()).toLong()
//        var sqrtMax = if(temp>Int.MAX_VALUE) Int.MAX_VALUE else temp.toInt()
        var sqrtMax = pow(10.toDouble(),i.toDouble()).toInt()
        var sqrtMin = pow(10.toDouble(),i.toDouble()-1).toInt()
        println("sqrtMax : $sqrtMax ")
        println("sqrtMin : $sqrtMin ")
        var middle = (sqrtMax+sqrtMin)/2
        while (sqrtMax-sqrtMin>1.1){
            if (middle.toLong()*middle.toLong()>x) sqrtMax = middle
            else sqrtMin = middle
            middle = (sqrtMax+sqrtMin)/2
        }
        return sqrtMin
    }
}

fun main(args: Array<String>) {
    val solution69 = Solution69()
    val t1 = System.nanoTime()
    println(solution69.mySqrt(2147395599))
    val t2 = System.nanoTime()
    println((t2-t1).toDouble()/1000000000.toDouble())
}