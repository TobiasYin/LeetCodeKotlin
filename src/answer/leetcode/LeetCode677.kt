package answer.leetcode

class MapSum {

    /** Initialize your data structure here. */
    private class Node(var isWord: Boolean = false) {
        val next = arrayOfNulls<Node>(26)
        var value: Int? = null
    }

    private val root = Node()


    fun insert(key: String, `val`: Int) {
        var now = root
        for (i in key) {
            if (now.next[i - 'a'] == null)
                now.next[i - 'a'] = Node()
            now = now.next[i - 'a']!!
        }
        now.isWord = true
        now.value = `val`
    }

    fun sum(prefix: String): Int {
        var now = root
        for (i in prefix) {
            if (now.next[i - 'a'] == null)
                return 0
            now = now.next[i - 'a']!!
        }
        return findSum(now)
    }

    private fun findSum(node: Node): Int {
        var result = 0
        if (node.isWord)
            result += node.value!!
        for (i in node.next) {
            if (i != null) {
                result += findSum(i)
            }
        }
        return result
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */

fun main(args: Array<String>) {
    val mapSum = MapSum()
    mapSum.insert("apple", 3)
    println(mapSum.sum("ap"))
    mapSum.insert("app", 2)
    println(mapSum.sum("ap"))
}