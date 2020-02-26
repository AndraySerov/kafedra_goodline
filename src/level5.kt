fun main(words: Array<String>) {
    val sorted_freq = words.groupingBy {it}
                           .eachCount()
                           .toList()
                           .sortedBy { (key, value) -> key }
                           .sortedByDescending { (key, value) -> value }

    for ((k, v) in sorted_freq)
        println("$k $v")
}
