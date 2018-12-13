package answer.leetcode

fun timeTest(times:Int=100,func:()->Unit):Double{
    val t1 = System.nanoTime()
    for(i in 1..times){
        func()
    }
    val t2 = System.nanoTime()
    return (t2-t1).toDouble()/10e9
}