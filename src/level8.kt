import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {

    val words: Array<String> = (

            if (args.isEmpty()) {
                Scanner(System.`in`).nextLine()
                    .split("\\p{Punct}+".toRegex())
                    .toTypedArray()

            } else if (args[0].equals("-f")) {

                try {
                    File(args[1]).readText(Charsets.UTF_8)
                        .split("\\p{Punct}+".toRegex())
                        .toTypedArray()
                } catch (e: FileNotFoundException) {
                    System.err.println(e)
                    exitProcess(1)
                }

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

