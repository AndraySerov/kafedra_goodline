import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.system.exitProcess
import kotlin.text.Charsets.UTF_8
import kotlin.Exception as Exception1
import kotlin.Pair as Pair1


fun main(args: Array<String>) {

    val words  = (
            when {
                args.isEmpty() -> {
                    Scanner(System.`in`).nextLine()
                        .split("[\\t\\n\\r\\s.,'-]+".toRegex())
                        .toTypedArray()

                }
                args[0] == "-f" -> {

                    try {
                        File(args[1]).readText(UTF_8)
                            .trim()
                            .split("[\\t\\n\\r\\s.,'-]+".toRegex())
                            .toTypedArray()
                    } catch(e: Exception) {
                        when (e) {
                            is FileNotFoundException,
                            is ArrayIndexOutOfBoundsException -> {
                                System.err.println(e)
                                exitProcess(1)
                            } else -> {
                                print("Unexpected error: ")
                                System.err.println(e)
                                exitProcess(1)
                            }
                        }
                    }
                } else -> args
            }
    )

    val sortedFreq = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key, _) -> key }
        .sortedByDescending { (_,value) -> value }

    for ((k, v) in sortedFreq)
        println("$k $v")
}
