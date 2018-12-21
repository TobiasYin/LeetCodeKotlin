package answer.leetcode

class Solution796 {
    fun rotateString(A: String, B: String): Boolean {
        if(A == B) return true
        val queue = Queue<Char>()
        for (i in A){
            queue.push(i)
        }
        val listB = B.toList()
        val listA = A.toList()
        do{
            queue.push(queue.pop())
            val list = queue.toList()
            if (listB == list){
                return true
            }
        }while (listA != list)
        return false
    }

    class Queue<T>(capacity: Int = 10) {
        var array = arrayOfNulls<Any>(capacity) as Array<T>
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
            if (empty) throw IndexOutOfBoundsException("No Element")
            val e = array[front]
            front = (front + 1) % array.size
            size--
            if (size == array.size / 4 && array.size / 2 != 0) resize(array.size / 2)
            return e
        }

        fun toList():List<T>{
            val result = arrayListOf<T>()
            for (i in 0 until size) {
                result.add(array[(front + i) % array.size])
            }
            return result
        }

    }
}

fun main(args: Array<String>) {
    val solution796 = Solution796()
    println(solution796.rotateString("abcde","cdeab"))
    println(solution796.rotateString("abcde","abced"))
    println(timeTest(100000) { solution796.rotateString("abcde","cdeab") })
}