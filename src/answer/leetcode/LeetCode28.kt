package answer.leetcode

class Solution28 {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.isEmpty()) return 0
        if(needle !in haystack) return -1
        val len = needle.length
        for (i in 0 until (haystack.length - len+1)){
            if(haystack.slice(i until  (i+len)) == needle){
                return i
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    println((0..1).toList().joinToString(""))
    println("hello".indexOf("lfds"))
}