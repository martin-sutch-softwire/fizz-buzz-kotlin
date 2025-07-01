fun main() {
    for (num in 1 .. 255) {
        var output =
            buildString {
                if (num % 11 == 0) append("Bong") else {
                    if (num % 3 == 0) append("Fizz")
                    if (num % 5 == 0) append("Buzz")
                    if (num % 7 == 0) append("Bang")
                }
                if (num % 13 == 0) {
                    val index = indexOf("B").takeIf { it != -1 } ?: count()
                    insert(index, "Fezz")
                }
            }
        if (num % 17 == 0) {
            val words = output.split("(?=[A-Z])".toRegex())
            output = words.reversed().joinToString("")
            }
        if (output == "") output = num.toString()
        println(output)
    }
}