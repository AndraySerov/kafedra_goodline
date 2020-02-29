fun main(args: Array<String>) {
    var words: Array<String>
    //check emty cmnd args
    if (args.size == 0) {
        val scan = java.util.Scanner(System.`in`)
        words = scan.nextLine().split("\\p{Punct}+".toRegex())
            .toTypedArray()
    } else {
        words = args
    }

    val sorted_freq = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key) -> key }
        .sortedByDescending { (value) -> value }

    for ((k, v) in sorted_freq)
        println("$k $v")
}
