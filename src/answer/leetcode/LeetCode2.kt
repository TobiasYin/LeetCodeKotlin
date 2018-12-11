package answer.leetcode

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val list1 = arrayListOf<Int>()
        val list2 = arrayListOf<Int>()
        var node = l1
        while (node != null) {
            list1.add(node.`val`)
            node = node.next
        }

        node = l2
        while (node != null) {
            list2.add(node.`val`)
            node = node.next
        }
        val tempList = if (list1.size >= list2.size) list1 else list2
        val tempMinList = if (list1.size < list2.size) list1 else list2
        val result = arrayListOf<ListNode>()
        for (i in 0..(tempList.size - 1)) {
            if (i < tempMinList.size) {
                val result_one = tempList[i] + tempMinList[i]
                if (result_one >= 10) {
                    result.add(ListNode(result_one - 10))
                    if (tempList.size>i+1) tempList[i + 1]++ else result.add(ListNode(1))
                } else {
                    result.add(ListNode(result_one))
                }
            } else {
                if (tempList[i]<10) result.add(ListNode(tempList[i])) else if  (tempList.size>i+1) {tempList[i + 1]++;result.add(ListNode(tempList[i]-10))} else{ result.add(ListNode(tempList[i]-10));result.add(ListNode(1))}
            }
        }
        for( i in 0..(result.size-1)){
            if (i != result.size - 1) result[i].next = result[i + 1]
        }
        return result[0]
    }
}