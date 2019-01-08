package answer.leetcode

class NumArray(val nums: IntArray) {

    fun sumRange(i: Int, j: Int): Int {
        var sum = 0
        for (index in i..j){
            sum += nums[index]
        }
        return sum
//        return nums.slice(i..j).sum() //鬼知道官方证明实现这个底层的,跑得太慢了,源代码看,slice复制了一遍,sum又遍历了一遍,但是我觉得也不该这么慢吧...我以为和Python的切片一样,高估它了....
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */

fun main(args: Array<String>) {
    val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(numArray.sumRange(0,2))
    println(numArray.sumRange(2,5))
    println(numArray.sumRange(1,3))
    println(timeTest(10000000) {
        numArray.sumRange(0,5)
        numArray.sumRange(0,2)
        numArray.sumRange(2,5)
        numArray.sumRange(1,3)
    })
}