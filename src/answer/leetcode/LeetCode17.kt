package answer.leetcode

class Solution17 {
    private val map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        return getRes(listOf(""),digits)
    }

    private fun getRes(set :List<String>, numSequence:String):List<String>{
        if (numSequence.isEmpty())
            return listOf()
        val res = arrayListOf<String>()
        for (i in set)
            for (j in map[numSequence[0]]?:"")
                res.add(i + j)
        if (numSequence.length == 1)
            return res
        return getRes(res, numSequence.substring(1))
    }
}

fun main() {
    val s = Solution17()
    println(s.letterCombinations("895389345754233457"))
}