import kotlin.math.max

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty() || (citations.size == 1 && citations[0] == 0)) return 0
        val data = citations.toList().sortedBy { -it }
        val h1 = h1(data)
        val h2 = h2(data)
        return max(h1, h2)
    }

    fun h1(data: List<Int>): Int {
        var i = 0
        for ((index, item) in data.withIndex()) {
            if (index + 1 >= item) {
                return item
            }
            i = index
        }
        return i + 1
    }

    fun h2(data: List<Int>): Int {
        for ((index, item) in data.withIndex()) {
            if (index + 1 >= item) {
                return index
            }
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val solution274 = Solution274()
    println(solution274.hIndex(intArrayOf(0, 0, 1, 2,2)))
}