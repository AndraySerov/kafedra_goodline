import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {

    val words: Array<String> = (

            if (args.isEmpty()) {
                Scanner(System.`in`).nextLine()
                    .split("[\\t\\n\\r\\s.,'-]+".toRegex())
                    .toTypedArray()

            } else if (args[0].equals("-f")) {

                try {
                    File(args[1]).readText(Charsets.UTF_8)
                        .trim()
                        .split("[\\t\\n\\r\\s.,'-]+".toRegex())
                        .toTypedArray()
                } catch (e: FileNotFoundException) {
                    System.err.println(e)
                    exitProcess(1)
                }

            } else args
            )

    val sortedFreq: List<Pair<String, Int>> = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key, _) -> key }
        .sortedByDescending { (_,value) -> value }

    for ((k, v) in sortedFreq)
        println("$k $v")
}
