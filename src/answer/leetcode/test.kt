package answer.leetcode

import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList

fun main() {
    val m = 100
    val n = 20
    println(randomInt(m, n).joinToString(","))
}

fun randomInt(m: Int, n: Int, predicate: (Int) -> Boolean = { true }) =
    Stream.generate(Math::random).map { (it * m).toInt() }.distinct().filter(predicate).limit(n.toLong()).toList()
