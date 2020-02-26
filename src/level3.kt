fun main(words: Array<String>) {
    for (word in words.distinct().sorted())
        println(word)
}