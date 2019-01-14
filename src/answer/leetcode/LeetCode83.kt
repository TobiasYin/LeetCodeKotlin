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

// 将传入的数字组装成链表, 因为需要在LeetCode提交的缘故,listNode不支持泛型,故不支持泛型,传参是可变个数整型参数
fun makeLinkedList(vararg data: Int): ListNode? {
    if (data.isEmpty()) return null
    val head = ListNode(`val` = data[0])
    var now = head
    for (i in 1 until data.size) {
        now.next = ListNode(`val` = data[i])
        now = now.next!!
    }
    return head
}

//传入链表头结点,返回一个IntArray. 用于链表测试.
fun getLinkedList(head: ListNode?): IntArray {
    if (head?.next == null) return if (head == null) intArrayOf() else intArrayOf(head.`val`)
    var now = head
    val result = arrayListOf<Int>()
    while (now != null) {
        result.add(now.`val`)
        now = now.next
    }
    return result.toIntArray()
}


fun main(args: Array<String>) {
    val solution83 = Solution83()
    val result = solution83.deleteDuplicates(makeLinkedList(1,1,1,2,2, 3, 4,4,4, 5,5,5))
    println(getLinkedList(result).joinToString(" "))
    println(getLinkedList(makeLinkedList(1, 2, 3, 4, 5)).joinToString(" "))
}