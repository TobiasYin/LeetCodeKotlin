package answer.leetcode

class MyStack {
    /** Initialize your data structure here. */
    private var queueIn = Queue<Int>()
    private var queueOut = Queue<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queueIn.push(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        while (queueIn.size > 1) {
            queueOut.push(queueIn.pop())
        }
        val e = queueIn.pop()
        while (!queueOut.empty) {
            queueIn.push(queueOut.pop())
        }
        return e
    }

    /** Get the top element. */
    fun top(): Int {
        while (queueIn.size > 1) {
            queueOut.push(queueIn.pop())
        }
        val e = queueIn.pop()
        while (!queueOut.empty) {
            queueIn.push(queueOut.pop())
        }
        queueIn.push(e)
        return e
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queueIn.empty
    }

}

class Queue<T>(capacity: Int = 10) {
    private var array = arrayOfNulls<Any>(capacity) as Array<T>
    var size = 0
    private var front = 0
    private var tail = 0
    val empty: Boolean
        get() = front == tail

    private fun resize(length: Int) {
        val temp = arrayOfNulls<Any>(length) as Array<T>
        for (i in 0 until size) {
            temp[i] = array[(front + i) % array.size]
        }
        array = temp
        front = 0
        tail = size
    }

    fun push(e: T) {
        array[tail] = e
        size++
        tail = (tail + 1) % array.size
        if (array.size == size) resize(2 * size)
    }

    fun pop(): T {
        val e = array[front]
        front = (front + 1) % array.size
        size--
        if (size == array.size / 4 && array.size / 2 != 0) resize(array.size / 2)
        return e
    }

    fun see(): T = array[front]

}

fun main(args: Array<String>) {
    val myStack = MyStack()
    myStack.push(12)
    for (i in 1..100) {
        myStack.push(i)
    }
    for (i in 1..100) {
        println(myStack.pop())
    }
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