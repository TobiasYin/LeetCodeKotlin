package answer.leetcode

class Solution336 {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val list = arrayListOf<List<Int>>()
        for (i in 0 until words.size) {
            for (j in i + 1 until words.size) {
                val word1 = words[i] + words[j]
                if (isPalindrome(word1)) {
                    list.add(listOf(i, j))
                }
                val word2 = words[j] + words[i]
                if (isPalindrome(word2)) {
                    list.add(listOf(j, i))
                }
            }
        }
        return list
    }

    fun isPalindrome(word: String): Boolean {
        for (i in 0..(word.length / 2)) {
            if (word[i] != word[word.length - i - 1])
                return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution336 = Solution336()
    println(solution336.palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll")))
    println(solution336.palindromePairs(arrayOf("bat","tab","cat")))
    println(solution336.isPalindrome("abccaa"))
    println(timeTest(100000) { solution336.palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll")) })
}