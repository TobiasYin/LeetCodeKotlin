package answer.leetcode

class Solution67 {
    fun addBinary(a: String, b: String): String {
        val stack = arrayListOf<Char>()
        val result = arrayListOf<Char>()
        fun addTwo(num1: Char, num2: Char): Char =
                when {
                    num1 == '1' && num2 == '1' -> {
                        stack.add('1')
                        '0'
                    }
                    num1 == '0' && num2 == '0' -> '0'
                    num1 == '1' && num2 == '0' -> '1'
                    num1 == '0' && num2 == '1' -> '1'
                    else -> ' '
                }
        val longer = if (a.length > b.length) a else b
        val shorter = if (a.length <= b.length) a else b
        for (i in 1..shorter.length) {
            var num1 = longer[longer.length - i]
            if (stack.isNotEmpty()) {
                val num0 = stack.removeAt(stack.lastIndex)
                num1 = addTwo(num0, num1)
            }
            val num2 = shorter[shorter.length - i]
            result.add(addTwo(num1, num2))
        }
        for (i in shorter.length + 1..longer.length){
            var num1 = longer[longer.length - i]
            if (stack.isNotEmpty()) {
                val num0 = stack.removeAt(stack.lastIndex)
                num1 = addTwo(num0, num1)
            }
            result.add(num1)
        }
        if (stack.isNotEmpty()) {
            result.add(stack.removeAt(stack.lastIndex))
        }
        return result.reversed().joinToString("")
    }
}

fun main(args: Array<String>) {
    val solution67 = Solution67()
    println(solution67.addBinary("111", "1"))
}