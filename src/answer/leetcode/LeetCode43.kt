package answer.leetcode

import java.lang.Exception

class Solution43 {
    fun multiply(num1: String, num2: String): String {
        val numList1 = num1.split("").asSequence().filter { it != "" }.map { it.toInt() }.toList().reversed()
        val numList2 = num2.split("").asSequence().filter { it != "" }.map { it.toInt() }.toList().reversed()
        val shorter = if (numList1.size > numList2.size) numList2 else numList1
        val longer = if (numList1.size <= numList2.size) numList2 else numList1
        val result = arrayListOf<List<Int>>()
        for (item in shorter) {
            val tempResult = arrayListOf<Int>()
            for ((index, i) in longer.withIndex()) {
                var results: Int = try {
                    tempResult[index]
                } catch (e: IndexOutOfBoundsException) {
                    0
                }
                val xResult = item * i
                results += xResult
                try {
                    tempResult[index] = (results % 10)
                } catch (e: IndexOutOfBoundsException) {
                    tempResult.add((results % 10))
                }
                if (results >= 10) {
                    tempResult.add((results / 10))
                }
            }
            result.add(tempResult)
        }
        result.forEachIndexed { index: Int, list: List<Int> ->
            val tempList = arrayListOf<Int>()
            for (i in 0 until index) {
                tempList.add(0)
            }
            tempList.addAll(list)
            result[index] = tempList
        }
        var answer: List<Int> = arrayListOf(0)
        for (i in result) {
            answer = addTwoNumbers(answer, i)
        }
        val answerString = answer.reversed().joinToString("")
        return try {
            answerString.toInt().toString()
        } catch (e: Exception) {
            answerString
        }
    }

    fun addTwoNumbers(list1: List<Int>, list2: List<Int>): List<Int> {
        val tempList = arrayListOf<Int>()
        val tempMinList = arrayListOf<Int>()
        tempList.addAll(if (list1.size >= list2.size) list1 else list2)
        tempMinList.addAll(if (list1.size < list2.size) list1 else list2)
        val resultList = arrayListOf<Int>()
        for (i in 0..(tempList.size - 1)) {
            if (i < tempMinList.size) {
                val resultOne = tempList[i] + tempMinList[i]
                if (resultOne >= 10) {
                    resultList.add(resultOne - 10)
                    if (tempList.size > i + 1) tempList[i + 1]++ else resultList.add(1)
                } else {
                    resultList.add(resultOne)
                }
            } else {
                if (tempList[i] < 10) resultList.add(tempList[i].toInt()) else if (tempList.size > i + 1) {
                    tempList[i + 1]++;resultList.add(tempList[i] - 10)
                } else {
                    resultList.add(tempList[i] - 10);resultList.add(1)
                }
            }
        }
        return resultList
    }
}

fun main(args: Array<String>) {
    val s = Solution43()
    println(s.multiply("123456789", "987654321"))
}