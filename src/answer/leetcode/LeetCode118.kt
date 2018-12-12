package answer.leetcode

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        if(numRows==0) return listOf()
        val result = arrayListOf(arrayListOf(1))
        for (i in 1 until numRows){
            val temp = arrayListOf<Int>()
            temp.add(1)
            if (i!=1)
                for (j in 0 until result[i-1].size-1){
                    temp.add(result[i-1][j]+result[i-1][j+1])
                }
            temp.add(1)
            result.add(temp)
        }
        return result
    }
}

fun main(args: Array<String>) {
    val solution118 = Solution118()
    println(solution118.generate(5))
}