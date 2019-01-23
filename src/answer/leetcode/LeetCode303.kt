package answer.leetcode

class NumArray(val nums: IntArray) {
    private val tree = IntArray(nums.size * 4)

    init {
        if (nums.isNotEmpty())
            buildSegmentTree(0, 0, nums.size - 1)
    }

    private fun leftChild(index: Int) = index * 2 + 1
    private fun rightChild(index: Int) = index * 2 + 2

    private fun buildSegmentTree(treeIndex: Int, left: Int, right: Int) {
        if (left == right) {
            tree[treeIndex] = nums[left]
            return
        }

        val mid = left + (right - left) / 2
        buildSegmentTree(leftChild(treeIndex), left, mid)
        buildSegmentTree(rightChild(treeIndex), mid + 1, right)

        tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)]
    }

    private fun query(treeIndex: Int, left: Int, right: Int, queryLeft: Int, queryRight: Int): Int {
        if (left == queryLeft && right == queryRight) return tree[treeIndex]
        val mid = left + (right - left) / 2
        return when {
            queryLeft >= mid + 1 -> query(rightChild(treeIndex), mid + 1, right, queryLeft, queryRight)
            queryRight <= mid -> query(leftChild(treeIndex), left, mid, queryLeft, queryRight)
            else -> query(leftChild(treeIndex), left, mid, queryLeft, mid) +
                    query(rightChild(treeIndex), mid + 1, right, mid + 1, queryRight)
        }
    }

    // 使用线段树重新实现了这道题
    fun sumRange(i: Int, j: Int): Int {
        if(nums.isEmpty()) return 0
        return query(0, 0, nums.size - 1, i, j)
    }

//    fun sumRange(i: Int, j: Int): Int {
//        var sum = 0
//        for (index in i..j){
//            sum += nums[index]
//        }
//        return sum
////        return nums.slice(i..j).sum() //鬼知道官方证明实现这个底层的,跑得太慢了,源代码看,slice复制了一遍,sum又遍历了一遍,但是我觉得也不该这么慢吧...我以为和Python的切片一样,高估它了....
//    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */

fun main(args: Array<String>) {
    val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(numArray.sumRange(0, 2))
    println(numArray.sumRange(2, 5))
    println(numArray.sumRange(1, 3))
    println(timeTest(10000000) {
        numArray.sumRange(0, 5)
        numArray.sumRange(0, 2)
        numArray.sumRange(2, 5)
        numArray.sumRange(1, 3)
    })
}