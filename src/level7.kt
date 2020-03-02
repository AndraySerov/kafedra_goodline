import java.util.Scanner


fun main(args: Array<String>) {

    val words: Array<String> = (
        if (args.isEmpty()) {
            Scanner(System.`in`).nextLine()
                .split("[\\s\\t\\n\\r]+".toRegex())
                .toTypedArray()
        } else args
    )


    val sortedFreq: List<Pair<String, Int>> = words.groupingBy {it}
            .eachCount()
            .toList()
            .sortedBy { (key,_) -> key }
            .sortedByDescending { (_, value) -> value }

    for ((k, v) in sortedFreq)
        println("$k $v")
}
