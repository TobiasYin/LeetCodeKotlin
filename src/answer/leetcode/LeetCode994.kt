package answer.leetcode

class Solution994 {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty())
            return 0
        var grid = grid
        var counter = 0
        var noOne = true
        outer@ for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val pos = grid[i][j]
                if (pos == 1) {
                    noOne = false
                    break@outer
                }
            }
        }
        if (noOne)
            return 0
        while (true) {
            val newGrid = Array(grid.size) { IntArray(grid[0].size) { 1 } }
            for (i in 0 until grid.size) {
                for (j in 0 until grid[i].size) {
                    val pos = grid[i][j]
                    if (pos == 0) {
                        newGrid[i][j] = pos
                    } else if (pos == 2) {
                        newGrid[i][j] = 2
                        if (j + 1 < grid[0].size)
                            newGrid[i][j + 1] = 2
                        if (i + 1 < grid.size)
                            newGrid[i + 1][j] = 2
                        if (i - 1 >= 0 && newGrid[i - 1][j] != 0)
                            newGrid[i - 1][j] = 2
                        if (j - 1 >= 0 && newGrid[i][j - 1] != 0)
                            newGrid[i][j - 1] = 2
                    }
                }
            }
            counter++
            grid = newGrid
            var noOne = true
            outer@ for (i in 0 until grid.size) {
                for (j in 0 until grid[i].size) {
                    val pos = grid[i][j]
                    if (pos == 1) {
                        noOne = false
                        break@outer
                    }
                }
            }
            if (noOne)
                break
            if (counter > 300)
                return -1
        }
        return counter
    }
}

fun main(args: Array<String>) {
//    val arr = Array<IntArray>(3) { IntArray(3) }
//    arr[0] = intArrayOf(2, 1, 1)
//    arr[1] = intArrayOf(1, 1, 0)
//    arr[2] = intArrayOf(0, 1, 1)
    val arr = Array<IntArray>(2) { IntArray(3) }
    arr[0] = intArrayOf(2)
    arr[1] = intArrayOf(0)
    val s = Solution994()
    println(timeTest(1) { println(s.orangesRotting(arr)) })
}