package answer.leetcode

class Solution7 {
    fun reverse(x: Int): Int {
        var bigThan0 = true
        val x_1 = if(x<0){ bigThan0 = false;-x}else{ x }
        val y = x_1.toString()
        var x_2:Int
        try {
            x_2 = y.reversed().toInt()
        }catch (e:NumberFormatException){
            return 0
        }
        if(!bigThan0){
            return -x_2
        }else{
            return x_2
        }
    }
}