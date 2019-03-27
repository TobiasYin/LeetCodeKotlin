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
class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null)
            return head
        val stack = Stack<ListNode>()
        var now = head
        while (now != null) {
            stack.push(now)
            now = now.next
        }
        var counter = 1
        while (counter != n) {
            stack.pop()
            counter++
        }
        val del = stack.pop()
        if (stack.isEmpty()) return del.next
        val pre = stack.pop()
        pre.next = del.next
        return head
    }
}

fun main() {
    val s = Solution19()
    println(getLinkedList(s.removeNthFromEnd(makeLinkedList(1,2,3,4,5),1)).joinToString(" "))
}