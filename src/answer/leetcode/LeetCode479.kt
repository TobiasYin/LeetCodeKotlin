package answer.leetcode

class Solution479 {
    fun largestPalindrome(n: Int): Int {
        if (n == 1) {
            return 9
        }
        val x = (Math.pow(10.toDouble(), n.toDouble()) - 1).toLong()
        for (i in x downTo Math.pow(10.toDouble(), (n - 1).toDouble()).toLong()) {
            for (j in x downTo Math.pow(10.toDouble(), (n - 1).toDouble()).toLong()) {
                val y = (i * j)
                val temp = y.toString()
                if (temp == temp.reversed()) {
                    return (y % 1337.toLong()).toInt()
                }
            }
        }
        return 0
    }
}

//待解决