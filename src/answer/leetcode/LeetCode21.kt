package answer.leetcode

class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null && l2==null){
            return null
        }else if(l1 == null){
            return l2
        }else if(l2 == null){
            return l1
        }
        var biggerNode = if (l1.`val` > l2.`val`) l1 else l2
        var smallerNode = if (l1.`val` <= l2.`val`) l2 else l1
        val firstNode = smallerNode

        while (true) {
            if (smallerNode.next != null && biggerNode.next != null) {
                if (biggerNode.`val` > smallerNode.next!!.`val`) smallerNode = smallerNode.next!!
                else {
                    val temp = smallerNode.next!!
                    smallerNode.next = biggerNode

                    if (temp.`val` > biggerNode.next!!.`val`) {
                        biggerNode = temp
                        smallerNode = biggerNode.next!!
                    } else {
                        smallerNode = temp
                        biggerNode = biggerNode.next!!
                    }
                }
            } else if (smallerNode.next == null) {
                smallerNode.next = biggerNode
                break
            } else if (biggerNode.next == null) {
                while (smallerNode.next != null) {
                    if (biggerNode.`val` > smallerNode.next!!.`val`) {
                        smallerNode = smallerNode.next!!
                        continue
                    } else {
                        val temp = smallerNode.next
                        smallerNode.next = biggerNode
                        biggerNode.next = temp
                        break
                    }
                }
                break
            }
        }
        return firstNode
    }
}