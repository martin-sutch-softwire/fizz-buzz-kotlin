fun main() {
    for (num in 1 .. 100) {
        var output = buildString {
            if (num % 3 == 0) append("Fizz")
            if (num % 5 == 0) append("Buzz")
        }
        if (output == "") output = num.toString()
        println(output)
    }
}