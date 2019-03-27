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
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummyHead = ListNode(-1)
        dummyHead.next = head
        var pre = dummyHead
        var first:ListNode? = null
        var now = dummyHead
        var counter = 0
        while (now.next!=null){
            now = now.next!!
            counter++
            if (counter%2 == 1){
                first = now
            }else{
                first!!.next = now.next
                now.next = first
                pre.next = now
                pre = first
                now = pre
            }
        }
        return dummyHead.next
    }
}

fun main() {
    val s = Solution24()
    println(getLinkedList(s.swapPairs(makeLinkedList(1,2,3,4))).joinToString(" "))
    println(s.swapPairs(null))
    println(null)
}