package answer.leetcode

class MyQueue {

    /** Initialize your data structure here. */
    private val stackIn = NStack<Int>()
    private val stackOut = NStack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stackIn.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        while (!stackIn.empty) {
            stackOut.push(stackIn.pop())
        }
        val e = stackOut.pop()
        while (!stackOut.empty) {
            stackIn.push(stackOut.pop())
        }
        return e
    }

    /** Get the front element. */
    fun peek(): Int {
        while (!stackIn.empty) {
            stackOut.push(stackIn.pop())
        }
        val e = stackOut.peek()
        while (!stackOut.empty) {
            stackIn.push(stackOut.pop())
        }
        return e
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean = stackIn.empty

}

class NStack<T>(capacity: Int = 10) {
    private var data = arrayOfNulls<Any>(capacity) as Array<T>
    var size = 0
    val empty get() = size == 0

    private fun resize(length: Int) {
        val temp = arrayOfNulls<Any>(length) as Array<T>
        for (i in 0 until size) {
            temp[i] = data[i]
        }
        data = temp
    }

    fun push(e: T) {
        data[size++] = e
        if (size == data.size) resize(size * 2)
    }

    fun pop(): T {
        val e = data[--size]
        if (size == data.size / 4 && data.size / 2 != 0) resize(data.size / 2)
        return e
    }

    fun peek(): T = data[size - 1]
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

fun main(args: Array<String>) {
    val queue = MyQueue()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    println(queue.pop())
    println(queue.pop())
    println(queue.peek())
    println(queue.pop())
    println(queue.pop())
    println(queue.empty())
}