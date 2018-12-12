package answer.leetcode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution144 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (!stack.empty) {
            val e = stack.pop()
            if (e.right != null) {
                stack.push(e.right!!)
            }
            if (e.left != null) {
                stack.push(e.left!!)
            }
            result.add(e.`val`)
        }
        return result
    }

    class Stack<T>(capacity: Int=10) {
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

    }

    class Queue<T>(capacity: Int = 10) {
        private var array = arrayOfNulls<Any>(capacity) as Array<T>
        var size = 0
        private var front = 0
        private var tail = 0
        val empty: Boolean
            get() = front == tail

        private fun resize(length: Int) {
            val temp = arrayOfNulls<Any>(length) as Array<T>
            for (i in 0 until size) {
                temp[i] = array[(front + i) % array.size]
            }
            array = temp
            front = 0
            tail = size
        }

        fun push(e: T) {
            array[tail] = e
            size++
            tail = (tail + 1) % array.size
            if (array.size == size) resize(2 * size)
        }

        fun pop(): T {
            val e = array[front]
            front = (front + 1) % array.size
            size--
            if (size == array.size / 4 && array.size / 2 != 0) resize(array.size / 2)
            return e
        }

        fun see(): T = array[front]
    }

}


fun main(args: Array<String>) {
    val queue = Solution144.Queue<Int>()
    for (i in 0..100) {
        queue.push(i)
    }
    println(queue.see())
    for (i in 0..100) {
        println(queue.pop())
    }
    val stack = Solution144.Stack<Int>()
    for (i in 0..100){
        stack.push(i)
    }
    println(stack.see())
    for(i in 0..100){
        println(stack.pop())
    }
}
