package answer.leetcode

class Solution168 {
    fun convertToTitle(n: Int): String {
        val resultList = arrayListOf<Char>()
        var div = n
        while (div != 0) {
            resultList.add((65 + (div - 1) % 26).toChar())
            div /= 26
            if (div % 26 == 0) div -= 1
        }
        return resultList.reversed().joinToString("")
    }
}
