package answer.leetcode

class Trie {
    private class Node(var isWord: Boolean = false) {
        val next = hashMapOf<Char, Node>()
    }

    var size = 0
        private set
    private val root = Node()

    fun insert(word: String) {
        var now = root
        for (i in word) {
            if (!now.next.containsKey(i))
                now.next[i] = Node()
            now = now.next[i]!!
        }
        if (!now.isWord) {
            now.isWord = true
            size++
        }
    }

    fun search(word: String): Boolean {
        var now = root
        for (i in word) {
            if (!now.next.containsKey(i))
                return false
            now = now.next[i]!!
        }
        return now.isWord
    }


    fun startsWith(pre: String): Boolean {
        var now = root
        for (i in pre) {
            if (!now.next.containsKey(i))
                return false
            now = now.next[i]!!
        }
        return true
    }

}