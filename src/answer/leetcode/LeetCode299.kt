package answer.leetcode

class Solution299 {
    fun getHint(secret: String, guess: String): String {
        var a = 0
        val map = hashMapOf<Char, Int>()
        for (i in secret) {
            val temp = map[i]
            if (temp != null) {
                map[i] = temp + 1
            } else {
                map[i] = 1
            }
        }
        var b = 0
        for ((index, item) in guess.withIndex()) {
            val sec = secret[index]
            if (item == sec) {
                a++
                map[sec] = map[sec]!! - 1
                if (map[sec] == -1){
                    b--
                    map[sec] = map[sec]!! + 1
                }
            } else {
                if (map[item] != null && map[item]!! != 0) {
                    map[item] = map[item]!! - 1
                    b++
                }
            }
        }
        return "${a}A${b}B"
    }
}

fun main(args: Array<String>) {
    val solution299 = Solution299()
    println(solution299.getHint("1807", "7810"))
    println(solution299.getHint(secret = "1123", guess = "0111"))
    println(solution299.getHint("1122","1222"))
}