package answer.leetcode

class Solution500 {
    fun findWords(words: Array<String>): Array<String> {
        val letters = listOf(
            hashSetOf('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'),
            hashSetOf('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'),
            hashSetOf('Z', 'X', 'C', 'V', 'B', 'N', 'M')
        )
        val result = arrayListOf<String>()
        back@for (i in words) {
            val item = i.toUpperCase()
            val letter = letters.filter { item[0] in it }[0]
            for (j in item){
                if(j !in letter){
                    continue@back
                }
            }
            result.add(i)
        }
        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val solution500 = Solution500()
    println(solution500.findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).joinToString(","))
    println(timeTest(100000) { solution500.findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")) })
}