package answer.leetcode

class Solution881 {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        if(people.size <2){
            return people.size
        }
        var num = 0
        people.sort()
        var i = 0
        var j = people.size-1
        while(i<j){
            if(people[i]+people[j]<=limit) i++
            num++
            j--
        }
        if(i==j) num++
        return num
    }
}