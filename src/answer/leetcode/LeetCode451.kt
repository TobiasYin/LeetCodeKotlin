package answer.leetcode

fun frequencySort(s: String): String {
    val set = s.toHashSet()
    val array = arrayListOf<Pair<Char, Int>>()
    for (i in set) {
        val count = s.count { it == i }
        array.add(i to count)
    }
    array.sortBy { -it.second }
    val stringBuilder = StringBuilder()
    for (i in array) {
        for (j in 1..i.second) stringBuilder.append(i.first)
    }
    return stringBuilder.toString()
}