package answer.leetcode

class Solution739 {
    fun dailyTemperatures(T: IntArray): IntArray {
        Outer@for (i in 0..T.lastIndex){
            for (j in i..T.lastIndex){
                if (T[j] > T[i]){
                    T[i] = j-i
                    continue@Outer
                }
            }
            T[i] = 0
        }
        return T
    }
}

fun main(args: Array<String>) {
    val solution739 = Solution739()
    println(solution739.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).joinToString())
}