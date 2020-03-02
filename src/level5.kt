fun main(words: Array<String>) {
    val sortedFreq = words.groupingBy {it}
                           .eachCount()
                           .toList()
                           .sortedBy { (key, _) -> key }
                           .sortedByDescending { (_, value) -> value }

    for ((k, v) in sortedFreq)
        println("$k $v")
}
