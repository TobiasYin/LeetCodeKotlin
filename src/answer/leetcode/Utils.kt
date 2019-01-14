package answer.leetcode

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
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

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Stack<E> {
    private var data = arrayOfNulls<Any>(10) as Array<E>
    private var size = 0
    val empty: Boolean
        get() = size == 0

    private fun resize(length: Int) {
        val newData = arrayOfNulls<Any>(length) as Array<E>
        for (i in 0 until size) {
            newData[i] = data[i]
        }
        data = newData
    }

    fun push(element: E) {
        if (size == data.size) resize(size * 2)
        data[size++] = element
    }

    fun pop(): E {
        val temp = data[--size]
        if (size < data.size / 4 && data.size / 2 != 0) resize(data.size / 2)
        return temp
    }

    fun peek(): E = data[size - 1]
}