package answer.leetcode

class Solution12 {
    fun intToRoman(num: Int): String {
        val keys = intArrayOf(1000, 500, 100, 50, 10, 5, 1)
        val values = charArrayOf('M', 'D', 'C', 'L', 'X', 'V', 'I')
        var now = num
        val res = StringBuilder()
        for ((index, key) in keys.withIndex()) {
            val div = now / key
            if (div == 0)
                continue
            if (div == 1 && index + 1 <= keys.lastIndex && now / keys[index + 1] == 9) {
                res.append(values[index + 1])
                res.append(values[index - 1])
                now -= 9 * keys[index + 1]
                continue
            }
            if (div == 4) {
                res.append(values[index])
                res.append(values[index - 1])
                now %= key
                continue
            }
            for (i in 1..div)
                res.append(values[index])
            now %= key
        }
        return res.toString()
    }
}

fun main() {
    val s = Solution12()
    println(s.intToRoman(3999))
}