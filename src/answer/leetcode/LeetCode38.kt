package answer.leetcode

class Solution38 {
    fun countAndSay(n: Int): String {
        var say = "1"
        for (i in 2..n) {
            say = getSay(say)
        }
        return say
    }

    private fun getSay(n: String): String {
        val saying = arrayListOf<ArrayList<Char>>()
        for ((index, i) in n.withIndex()) {
            if (index == 0) {
                saying.add(arrayListOf(i))
                continue
            }
            if (i == saying[saying.size - 1][0]) saying[saying.size - 1].add(i)
            else saying.add(arrayListOf(i))
        }
        val stringBuilder = StringBuilder()
        saying.forEach{
            stringBuilder.append(it.size)
            stringBuilder.append(it[0])
        }
        return stringBuilder.toString()
    }
}
