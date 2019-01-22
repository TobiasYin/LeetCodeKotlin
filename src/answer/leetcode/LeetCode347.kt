package answer.leetcode

class Solution347 {
    class BinaryMaxHeap<E : Comparable<E>> constructor(capacity: Int = 10) {
        private val data = ArrayList<E>(capacity)
        val size
            get() = data.size
        val empty
            get() = data.isEmpty()

        constructor(list: List<E>) : this() {
            for (i in list) {
                data.add(i)
            }
            for (i in parent(list.size - 1) downTo 0)
                siftDown(i)
        }


        private fun parent(index: Int): Int {
            if (index !in 1 until size) {
                throw IndexOutOfBoundsException()
            }
            return (index - 1) / 2
        }

        private fun leftChild(index: Int): Int {
            return index * 2 + 1
        }

        private fun rightChild(index: Int): Int {
            return index * 2 + 2
        }

        fun add(element: E) {
            data.add(element)
            siftUp(size - 1)
        }

        private fun siftUp(index: Int) {
            var nowIndex = index
            while (nowIndex != 0 && data[nowIndex] > data[parent(nowIndex)]) {
                swap(parent(nowIndex), nowIndex)
                nowIndex = parent(nowIndex)
            }
        }

        fun findMax(): E = data[0]

        fun extractMax(): E {
            val max = data[0]
            data[0] = data[size - 1]
            data.removeAt(size - 1)
            siftDown(0)
            return max
        }

        private fun swap(i: Int, j: Int) {
            val temp = data[i]
            data[i] = data[j]
            data[j] = temp
        }

        private fun siftDown(index: Int) {
            var nowIndex = index
            while (leftChild(nowIndex) < size) {
                var child = leftChild(nowIndex)
                if (rightChild(nowIndex) < size && data[rightChild(nowIndex)] > data[child])
                    child++
                if (data[child] > data[nowIndex]) {
                    swap(child, nowIndex)
                    nowIndex = child
                } else break
            }
        }

        fun replace(element: E): E {
            val max = data[0]
            data[0] = element
            siftUp(0)
            return max
        }

    }

    class CP(val key: Int, val value: Int) : Comparable<CP> {
        override fun compareTo(other: CP): Int {
            return -value.compareTo(other.value)
        }
    }

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = hashMapOf<Int, Int>()
        for (i in nums) {
            map[i] = (map[i] ?: 0) + 1
        }
        val heap = BinaryMaxHeap<CP>(k)
        for (i in map.keys) {
            val temp = CP(i,map[i]!!)
            if (heap.size == k){
                if (heap.findMax() > temp){
                    heap.extractMax()
                    heap.add(temp)
                }
            }else{
                heap.add(temp)
            }
        }
        val res = arrayListOf<Int>()
        for (i in 0 until heap.size){
            res.add(heap.extractMax().key)
        }
        return res.reversed()
    }
}

fun main(args: Array<String>) {
    val solution347 = Solution347()
    println(solution347.topKFrequent(intArrayOf(1,1,1,2,2,3),2).joinToString(" "))
}