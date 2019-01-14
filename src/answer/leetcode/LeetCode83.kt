package answer.leetcode

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class Solution83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var pre = head
        while (pre != null) {
            if (pre.next != null) {
                if (pre.`val` == pre.next!!.`val`) {
                    pre.next = pre.next!!.next
                    continue
                }
            }
            pre = pre.next
        }
        return head
    }
}


fun main(args: Array<String>) {
    val solution83 = Solution83()
    val result = solution83.deleteDuplicates(makeLinkedList(1,1,1,2,2, 3, 4,4,4, 5,5,5))
    println(getLinkedList(result).joinToString(" "))
    println(getLinkedList(makeLinkedList(1, 2, 3, 4, 5)).joinToString(" "))
}