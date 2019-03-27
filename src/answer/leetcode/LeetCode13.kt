package answer.leetcode

class Solution13 {
    fun romanToInt(s: String): Int {
        val map = mapOf(
            "M" to 1000,
            "D" to 500,
            "C" to 100,
            "L" to 50,
            "X" to 10,
            "V" to 5,
            "I" to 1,
            "CM" to 900,
            "CD" to 400,
            "XC" to 90,
            "XL" to 40,
            "IV" to 4,
            "IX" to 9
        )
        val set = setOf('C', 'X', 'I')
        var res = 0
        var i = 0
        while (i < s.length) {
            if (s[i] in set && i + 1 < s.length) {
                val v = map["${s[i]}${s[i + 1]}"]
                if (v != null) {
                    res += v
                    i += 2
                    continue
                }
            }
            res += map[s[i].toString()] ?: 0
            i++
        }
        return res
    }
}

fun main() {
    val s = Solution13()
    val s1 = Solution12()
    println(s.romanToInt(s1.intToRoman(1)))
    println(timeTest(1) {
        for (i in 0..3999){
            if (i != s.romanToInt(s1.intToRoman(i))){
                println(false)
            }
        }
    })
}