import java.util.Scanner


fun main(args: Array<String>) {

    val words: Array<String> = (
        if (args.isEmpty()) {
            Scanner(System.`in`).nextLine()
                .split("\\p{Punct}+".toRegex())
                .toTypedArray()
        } else args
    )


    val sorted_freq: List<Pair<String, Int>> = words.groupingBy {it}
            .eachCount()
            .toList()
            .sortedBy { (key) -> key }
            .sortedByDescending { (value) -> value }

    for ((k, v) in sorted_freq)
        println("$k $v")
}
