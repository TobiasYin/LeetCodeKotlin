package answer.leetcode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution145 {
    private val stack = Stack<TreeNode>()
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        add(root)
        val result = mutableListOf<Int>()
        println(stack.toString { it.`val`.toString() })
        while (!stack.empty) {
            result.add(stack.pop().`val`)
        }
        return result
    }

    tailrec fun add(node: TreeNode) {
        stack.push(node)
        if (node.right != null) add(node.right!!)
        if (node.left != null) add(node.left!!)
    }

    class Stack<T>(capacity: Int = 10) {
        private var array = arrayOfNulls<Any>(capacity) as Array<T>
        val empty: Boolean get() = size == 0
        var size = 0

        private fun resize(length: Int) {
            val temp = arrayOfNulls<Any>(length) as Array<T>
            for (i in 0 until size) {
                temp[i] = array[i]
            }
            array = temp
        }

        fun push(e: T) {
            array[size++] = e
            if (size == array.size) resize(2 * size)
        }

        fun pop(): T {
            val e = array[--size]
            if (size == array.size / 4 && array.size / 2 != 0) resize(array.size / 2)
            return e
        }

        fun see(): T = array[size - 1]
        fun toString(e:(T)->String): String {
            return array.sliceArray(0 until size).joinToString (",",transform = e)
        }

    }

}

fun main(args: Array<String>) {
    val solution145 = Solution145()
    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)
    val n6 = TreeNode(6)
    val n7 = TreeNode(7)
    val n8 = TreeNode(8)
    val n9 = TreeNode(9)
    val n10 = TreeNode(10)
    val n11 = TreeNode(11)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = n7
    n4.left = n8
    n4.right = n9
    n5.left = n10
    n5.right = n11
    println(solution145.postorderTraversal(n1))

}