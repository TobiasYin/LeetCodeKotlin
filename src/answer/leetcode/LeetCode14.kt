package answer.leetcode

import java.lang.StringBuilder

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        val str = StringBuilder()
        val len = strs.map { it.length }.min()?:0
        label@for (i in 0 until len){
            val x = strs[0][i]
            for (j in 1 until strs.size){
                if (strs[j][i]!=x) break@label
            }
            str.append(x)
        }
        return str.toString()
    }
}

fun main(args: Array<String>) {
    val solution14 = Solution14()
    val array = arrayOf("flower","flow","flight")
    println(solution14.longestCommonPrefix(array))
}