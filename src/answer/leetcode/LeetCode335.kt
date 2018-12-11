package answer.leetcode

fun isSelfCrossing(z: IntArray): Boolean {
    if (z.size <= 2) {
        return false
    }
    val set = hashSetOf<Pair<Int, Int>>(0 to 0)
    var x = 0
    var y = 0
    for (j in 0 until z.size) {
        when (j % 4) {
            0 -> {
                for (i in 1..z[j]) {
                    y++
                    val temp = x to y
                    if (temp in set) {
                        return true
                    } else {
                        set.add(temp)
                    }
                }
            }
            1 -> {
                for (i in 1..z[j]) {
                    x--
                    val temp = x to y
                    if (temp in set) {
                        return true
                    } else {
                        set.add(temp)
                    }
                }
            }
            2 -> {
                for (i in 1..z[j]) {
                    y--
                    val temp = x to y
                    if (temp in set) {
                        return true
                    } else {
                        set.add(temp)
                    }
                }
            }
            3 -> {
                for (i in 1..z[j]) {
                    x++
                    val temp = x to y
                    if (temp in set) {
                        return true
                    } else {
                        set.add(temp)
                    }
                }
            }
        }
    }
    return false
}