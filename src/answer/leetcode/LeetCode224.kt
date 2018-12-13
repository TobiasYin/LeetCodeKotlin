package answer.leetcode

class Solution {
    fun calculate(s: String): Int {

    }

    class Sum(val x: Node, val y: Node) : Node, Operator {
        override fun eval(): Node {
            when {
                x is Value && y is Value -> return Value(x.x + y.x)
                x is Value && y is Operator -> {
                    var temp = y.eval()
                    while (temp !is Value) {
                        temp = temp.eval()
                    }
                    return x+temp
                }
                x is Operator && y is Value -> {
                    var temp = x.eval()
                    while (temp !is Value) {
                        temp = temp.eval()
                    }
                    return y+temp
                }
                else -> {
                    var tempX = x.eval()
                    var tempY = y.eval()
                    while (tempX !is Value){
                        tempX = tempX.eval()
                    }
                    while (tempY !is Value){
                        tempY = tempY.eval()
                    }
                    return tempX+tempY
                }
            }
        }

        override fun plus(x: Node): Node {
            
        }
    }

    class Value(val x: Int) : Node {
        override fun eval(): Node {
            return this
        }

        override operator fun plus(y: Node): Node {
            if (y is Value) return Value(x + y.x)
            else if (y is Operator) return Value(x + (y.eval() as Value).x)
        }

    }

    interface Node {
        fun eval(): Node
        operator fun plus(x: Node): Node
    }

    interface Operator
}