package answer.leetcode

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        val tempList = digits.toMutableList()
        tempList.reverse()
        val tempMinList = listOf(1)
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
        return resultList.reversed().toIntArray()
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