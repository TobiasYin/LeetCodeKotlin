package answer.leetcode

class Solution722 {
    fun removeComments(source: Array<String>): List<String> {
        var flag =false
        val list = arrayListOf<String>()
        list.addAll(source)
        val toRemove = arrayListOf<Int>()
        for( (index,item) in list.withIndex() ){
            val item_trim = item.trim()
            if(item_trim.length<2){
                continue
            }
            if(flag){
                toRemove.add(index)
                if(item_trim.substring(item_trim.length-2,item_trim.length)=="*/"){
                    flag = false
                }
                continue
            }
            if(item_trim.substring(0,2) == "//"){
                toRemove.add(index)
            }else if(item_trim.substring(0,2) == "/*"){
                flag = true
                toRemove.add(index)
                if(item_trim.substring(item_trim.length-2,item_trim.length)=="*/"){
                    flag = false
                }
            }
        }
        for(i in toRemove.reversed()){
            list.removeAt(i)
        }
        return list.toList()
    }
}

//待解决