package answer.leetcode

class Solution344 {
    fun reverseString(s: String): String {
        val res = StringBuilder()
        for(i in 1..s.length){
            res.append(s[s.length - i])
        }
        return res.toString()
    }
// 最简写法, 效率略低
//    fun reverseString(s:String) = s.reversed()
}