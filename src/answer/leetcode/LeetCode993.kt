package answer.leetcode


//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//}

class Solution993 {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val x_pos = trace(root,x,0)
        val y_pos = trace(root, y, 0)
        if (x_pos == null || y_pos == null)
            return false
        return x_pos.first!=y_pos.first && x_pos.second == y_pos.second
    }

    fun trace(node:TreeNode?, x:Int, deep:Int):Pair<TreeNode, Int>?{
        if (node == null)
            return null
        if (node.left?.`val` == x || node.right?.`val` == x)
            return node to deep+1
        val left = trace(node.left, x,deep+1)
        val right = trace(node.right, x,deep+1)
        return left ?: right
    }
}

fun main(args: Array<String>) {
    val s297 = LeetCode297()
    val node = s297.deserialize("[1,2,3,null,4,6,5]")
    val s = Solution993()
    println(s.isCousins(node,4,6))
}