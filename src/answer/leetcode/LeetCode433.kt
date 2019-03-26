package answer.leetcode

import java.util.LinkedList
import java.util.Queue

class Solution433 {
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        var counters = arrayListOf<Int>()
        val queue: Queue<String> = LinkedList<String>()
        queue.add(start)
        while (queue.isNotEmpty()) {
            var now = queue.remove()
            var counter = 0
            while (now != end) {
                val lastNow = now
                for (index in 0 until bank.size) {
                    val s = bank[index]
                    var c = 0
                    for (i in 0 until s.length) {
                        if (s[i] != now[i])
                            c++
                    }
                    if (c == 1) {
                        counter++
                        now = s
                        queue.add(now)
                    }
                }
                if (now == lastNow)
                    break
            }
            counters.add(counter)
        }
        return counters.min() ?: -1
    }
}