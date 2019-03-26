package answer.leetcode

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (t.isEmpty() && s.isNotEmpty())
            return false
        var index = 0
        for (i in s){
            while(t[index++] != i){
                if(index - 1 >= t.length-1)
                    return false
            }
            if (index >= t.length)
                return false
        }
        return true
    }
}

fun main() {
    val s = Solution392()
    val a = "axc"
    val b = "ahbgdc"
    println(b.length)
    val res = s.isSubsequence(a,b)
    println(res)
}