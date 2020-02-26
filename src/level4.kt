fun main(words: Array<String>) {
    val frequency = words.groupingBy {it}.eachCount()
    for (k in frequency.keys)
        println("$k ${frequency[k]}")
}
