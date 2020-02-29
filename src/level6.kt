fun main(args: Array<String>) {
    var words: Array<String>
    //check emty cmnd args
    if (args.isEmpty()) {
        val scan = java.util.Scanner(System.`in`)
        words = scan.nextLine().split("[\\s\\t\\n\\r]+".toRegex())
            .toTypedArray()
    } else {
        words = args
    }

    val sorted_freq = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key,value) -> key }
        .sortedByDescending { (key,value) -> value }

    for ((k, v) in sorted_freq)
        println("$k $v")
}
