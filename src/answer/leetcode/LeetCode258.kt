package answer.leetcode

class Solution254 {
    fun addDigits(num: Int): Int {
        if(num == 0) return 0
        return (num-1)%9+1
    }
}
