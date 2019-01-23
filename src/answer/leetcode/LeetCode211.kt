package answer.leetcode


class WordDictionary() {
    private class Node(var isWord: Boolean = false) {
        val next = arrayOfNulls<Node>(26)
    }

    /** Initialize your data structure here. */
    private val root = Node()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var now = root
        for (i in word) {
            if (now.next[i - 'a'] == null)
                now.next[i - 'a'] = Node()
            now = now.next[i - 'a']!!
        }
        now.isWord = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return search(root, word)
    }

    private fun search(node: Node, word: String): Boolean {
        var now = node
        for ((index, i) in word.withIndex()) {
            if (i != '.' && now.next[i - 'a'] == null) return false
            else if (i == '.') {
                return searchAll(now, word.slice(index + 1 until word.length))
            }
            now = now.next[i - 'a']!!
        }
        return now.isWord
    }

    private fun searchAll(node: Node, word: String): Boolean {
        for (i in node.next) {
            if (i != null) {
                if (search(i, word)) return true
            }
        }
        return false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

fun main(args: Array<String>) {
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mom")
    println(wordDictionary.search("bad"))
    println(wordDictionary.search(".ad"))
}