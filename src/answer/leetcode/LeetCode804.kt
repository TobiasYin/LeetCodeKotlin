package answer.leetcode

class Solution804 {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val code = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val res = hashSetOf<String>()
        for (word in words){
            val s = StringBuilder()
            for (i in word){
                s.append(code[i-'a'])
            }
            res.add(s.toString())
        }
        return res.size
    }
}