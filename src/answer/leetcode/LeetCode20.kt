package answer.leetcode

class Solution20 {
    fun isValid(s: String): Boolean {
        val left = "[{("
        val right = "]})"
        val stack = Stack<Char>()
        for (i in s) {
            if (i in left) {
                stack.push(i)
            } else if (i in right) {
                if (stack.empty) {
                    return false
                }
                if (when (stack.pop()) {
                        '(' -> i == ')'
                        '[' -> i == ']'
                        '{' -> i == '}'
                        else -> false
                    }
                ) {
                    continue
                } else {
                    return false
                }
            } else {
                return false
            }
        }
        if (stack.empty) {
            return true
        }
        return false
    }
}
