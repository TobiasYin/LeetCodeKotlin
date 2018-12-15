package answer.leetcode

class MyStack {
    /** Initialize your data structure here. */
    private var queue = arrayListOf<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue.add(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return queue.removeAt(queue.size - 1)
    }

    /** Get the top element. */
    fun top(): Int {
        return queue[queue.size - 1]
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue.isEmpty()
    }

}

class MyQueue<T>(capacity: Int = 10) {
    var array = arrayOfNulls<Any>(capacity + 1) as Array<T>
    private var front = 0
    private var tail = 0
    var size = 0
    val empty: Boolean
        get() = size == 0

    fun resize(length: Int) {
        val temp = arrayOfNulls<Any>(length+1) as Array<T>
        array = temp
    }

    fun push(e: T) {
        array[tail] = e
        tail = (tail + 1) % array.size
    }

    fun pop(): T {
        val e = array[front]
        return e
    }

}

fun main(args: Array<String>) {
    val myStack = MyStack()
    myStack.push(12)
    println(myStack.top())
    println(myStack.pop())
    println(myStack.empty())
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */