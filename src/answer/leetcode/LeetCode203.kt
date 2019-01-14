package answer.leetcode

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummyHead = ListNode(-1)
        dummyHead.next = head
        var pre: ListNode? = dummyHead
        while (pre != null) {
            if (pre.next?.`val` == `val`) {
                pre.next = pre.next?.next
                continue
            }
            pre = pre.next
        }
        return dummyHead.next
    }

    //递归实现
    fun removeElementSelf(head: ListNode?, `val`: Int): ListNode? {
        return if (head?.`val` == `val`)
            removeElementSelf(head.next, `val`)
        else {
            head?.next = removeElementSelf(head?.next, `val`)
            head
        }
    }
}

fun main(args: Array<String>) {
    val solution203 = Solution203()
    val list = makeLinkedList(1, 2, 3, 6, 4, 3, 2, 6)!!
    val result = getLinkedList(solution203.removeElementSelf(list, 6))
//    println(getLinkedList(solution203.removeElements(makeLinkedList(1, 2, 6, 3, 4, 5, 6), 6)).joinToString(" -> "))
//    println(getLinkedList(solution203.removeElements(makeLinkedList(1, 1), 1)).joinToString(" -> "))
//    println(solution203.removeElements(null, 3))
    println(result.joinToString(" -> "))
}