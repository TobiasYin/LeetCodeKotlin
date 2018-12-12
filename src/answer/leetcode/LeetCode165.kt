package answer.leetcode

import java.lang.IndexOutOfBoundsException
import kotlin.math.max

class Solution165 {
    fun compareVersion(version1: String, version2: String): Int {
        val versionList1 = version1.split(".")
        val versionList2 = version2.split(".")
        var i = 0
        while (true) {
            val n1 = getValue { versionList1[i] }
            val n2 = getValue { versionList2[i++] }
            if (n1 > n2) {
                return 1
            } else if (n1 < n2) {
                return -1
            }
            if (i > max(versionList1.size, versionList2.size)){
                return 0
            }
        }
    }

    private inline fun getValue(f: () -> String) = try {
        f().toInt()
    } catch (e: IndexOutOfBoundsException) {
        0
    }
}

fun main(args: Array<String>) {
    val version1 = "01"
    val version2 = "1"
    val solution165 = Solution165()
    println(solution165.compareVersion(version1, version2))
}
