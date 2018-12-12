package answer.leetcode

class Solution119 {
    fun getRow(rowIndex: Int): List<Int> {
        return generate(rowIndex+1)[rowIndex]
    }
    private fun generate(numRows: Int): List<List<Int>> {
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
//刚刚写了获取杨辉三角的代码,偷个懒直接获取了.
fun main(args: Array<String>) {
    val solution119 = Solution119()
    println(solution119.getRow(3))
}