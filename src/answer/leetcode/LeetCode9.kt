package answer.leetcode

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if(x<0) return false
        if(x == 0) return true
        var s = x.toString()
        return s == s.reversed()
    }
}