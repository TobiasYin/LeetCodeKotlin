package answer.leetcode

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s
        val res = StringBuilder()
        for( i in 1..numRows){
            var j = i
            while (j <= s.length){
                res.append(s[j-1])
                val v = j + (numRows - i) * 2
                val then = j + (numRows - 1) * 2
                if (v!=j && then!=v && v <= s.length){
                    res.append(s[v-1])
                }
                j = then
            }
        }
        return res.toString()
    }
}

fun main() {
    val s = Solution6()
    println(s.convert("A", 1))
}