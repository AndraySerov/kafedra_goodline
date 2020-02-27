fun main() {
    val scan = java.util.Scanner(System.`in`)
    val words = scan.nextLine().split(" ")

    val sorted_freq = words.groupingBy {it}
        .eachCount()
        .toList()
        .sortedBy { (key) -> key }
        .sortedByDescending { (value) -> value }

    for ((k, v) in sorted_freq)
        println("$k $v")
}
