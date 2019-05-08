package answer.leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution23 {
    private var nodeList: Array<ListNode?>? = null
    private val MaxNode = ListNode(Int.MAX_VALUE)
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty())
            return null
        nodeList = lists
        val head = getMin()
        if (head == MaxNode)
            return null
        var now = head
        var next = getMin()
        while (next != MaxNode) {
            now.next = next
            now = next
            next = getMin()
        }
        return head
    }


    private fun getMin(): ListNode {
        var min:ListNode
        var minIndex:Int
        if (nodeList!![0]!=null) {
            min = nodeList!![0]!!
            minIndex = 0
        }else{
            min = MaxNode
            minIndex = -1
        }
        for ((index, i) in nodeList!!.withIndex()) {
            if (min.`val` > i?.`val` ?: Int.MAX_VALUE) {
                min = i!!
                minIndex = index
            }
        }
        if (minIndex != -1)
            nodeList!![minIndex] = nodeList!![minIndex]!!.next
        return min
    }
}

fun main() {
    val s = Solution23()
    val res = s.mergeKLists(arrayOf(makeLinkedList(1, 4, 5), makeLinkedList(1, 3, 4), makeLinkedList(2, 6)))
    println(getLinkedList(res).joinToString(" "))
}