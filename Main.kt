fun getExitMessage(code: Int): String? {
    return when (code) {
        130 -> "An infinite loop has occurred.."
        1 -> "An error has occurred.."
        0 -> "The program has executed successfully.."
        else -> null
    }
}

fun collectKnownExitCode(code: Int, result: MutableList<Pair<Int, String>>  ) {
    val message = getExitMessage(code)
    if (message != null) {
        result.add(code to message)
    }
}

fun forLoop(): List<Pair<Int, String>> {
   val results = mutableListOf<Pair<Int, String>>()
    for (i in 130 downTo 0) {
        collectKnownExitCode(i, results)
    }

    return results
}

fun whileLoop(exitCode: Int):  List<Pair<Int, String>> {
    var number = exitCode
    val results = mutableListOf<Pair<Int, String>>()

    while (number > 0) {
        number--
        collectKnownExitCode(number, results)

    }

    return results
}

fun doWhileLoop(exitCode: Int): List<Pair<Int, String>> {
    var number = exitCode
    val results = mutableListOf<Pair<Int, String>>()

    do {
        number--
        collectKnownExitCode(number, results)

    } while (number > 0)

    return results
}

fun printResults(title: String, results: List<Pair<Int, String>>) {
    println("\n$title")
    for ((code, message) in results) {
        println(message)
        println("exit code = $code")
    }
}

fun main() {

    printResults(title = "FOR LOOP ....", results = forLoop())
    printResults(title = "WHILE LOOP ....", results = whileLoop(exitCode = 131))
    printResults(title = "DO..WHILE LOOP ....", results = doWhileLoop(exitCode = 131))


}
