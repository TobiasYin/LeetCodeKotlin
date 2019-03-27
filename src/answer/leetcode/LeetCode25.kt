package answer.leetcode

import java.util.Stack

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head==null || k == 1)
            return head
        val dummyHead = ListNode(-1)
        dummyHead.next = head
        var pre = dummyHead
        var first: ListNode = head
        var last: ListNode
        var now = dummyHead
        var counter = 0
        while (now.next != null) {
            now = now.next!!
            counter++
            if (counter % k == 1) {
                first = now
            } else if (counter % k == 0) {
                last = now
                reverse(first, last, pre)
                pre = first
                now = first
            }
        }
        return dummyHead.next
    }

    private fun reverse(start: ListNode, last: ListNode, pre:ListNode) {
        val stack = Stack<ListNode>()
        var now = start
        while (now!=last){
            stack.add(now)
            now = now.next!!
        }
        start.next = last.next
        now = last
        while (stack.isNotEmpty()){
            now.next = stack.pop()
            now = now.next!!
        }
        pre.next = last
    }
}

fun main() {
    val s = Solution25()
    println(getLinkedList(s.reverseKGroup(makeLinkedList(1,2,3,4,5),1)).joinToString(" "))
}