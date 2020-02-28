fun main(args: Array<String>) {
    try {
        val file = java.io.File(args[1])
        val words = file.readText(Charsets.UTF_8).split(" ")

        val sortedFreq = words.groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { (key) -> key }
            .sortedByDescending { (value) -> value }

        for ((k, v) in sortedFreq)
            println("$k $v")
    } catch(t: Throwable) {

        print("File is not exists")
    }
}
