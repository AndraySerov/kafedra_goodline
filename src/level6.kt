fun main(args: Array<String>) {
    val words: Array<String>
    //check emty cmnd args
    if (args.isEmpty()) {
        val scan = java.util.Scanner(System.`in`)
        words = scan.nextLine().split("[\\s\\t\\n\\r]+".toRegex())
            .toTypedArray()
    } else {
        words = args
    }

    val sortedFreq = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key,_) -> key }
        .sortedByDescending { (_,value) -> value }

    for ((k, v) in sortedFreq)
        println("$k $v")
}
