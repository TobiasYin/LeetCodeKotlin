package answer.leetcode

class MinStack() {

    /** initialize your data structure here. */
    var array = IntArray(10)
    var size = 0
    private var min = 0

    fun resize(length: Int) {
        val tempArray = IntArray(length)
        for (i in 0 until size) {
            tempArray[i] = array[i]
        }
        array = tempArray
    }

    fun push(x: Int) {
        min = when {
            size == 0 || x < min -> x
            else -> min
        }
        array[size++] = x
        if (size == array.size) resize(size * 2)
    }

    fun pop() {
        size--
        if (min == array[size]) min = array.filterIndexed { index, i -> index < size }.min() ?: 0
        if (size < array.size / 4) resize(array.size / 2)
    }

    fun top(): Int {
        return array[size - 1]
    }

    fun getMin(): Int {
        return min
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
fun main(args: Array<String>) {
    val stack = MinStack()
    for (i in -20..20) {
        stack.push(i)
    }
    println(stack.top())
    println(stack.getMin())
    for (i in 1..10) {
        stack.pop()
    }
    println(stack.top())
    println(stack.getMin())
    val newStack = MinStack()
    newStack.push(-2)
    newStack.push(0)
    newStack.push(-3)
    println(newStack.getMin())
    newStack.pop()
    println(newStack.top())
    println(newStack.getMin())
}
//获取最小值的时间复杂度平均后依然是O(1),但是可以通过链表的方式来维护最小值,更稳定