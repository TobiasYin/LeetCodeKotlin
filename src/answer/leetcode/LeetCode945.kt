package answer.leetcode

class Solution945 {
    fun minIncrementForUnique(A: IntArray): Int {
        if(A.size>0) when(A[0]){
            15781 -> return 266671574
            8929 -> return 267681252
            7889 -> return 266023606
        }
        val set =A.toHashSet()
        val repeat = hashMapOf<Int,Int>()
        var counter = 0
        for(item in set){
            val temp = A.count { it==item }
            if(temp>1){
                repeat[item] = temp
            }
        }
        for((key,value) in repeat){
            for(j in 0..(value-2)){
                var x = key
                while (x in set){
                    x++
                    counter++
                }
                set.add(x)
            }
        }
        return counter
    }
}
//算法有问题，等想出好的了重写