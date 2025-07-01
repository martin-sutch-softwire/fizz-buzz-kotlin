//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var num = 1
    while (num <= 100 ) {
        var ln = ""

        if (num % 3 == 0) {
            ln += "Fizz"
        }

        if (num % 5 == 0) {
            ln += "Buzz"
        }

        if (ln == "") {
            ln = num.toString()
        }

        println(ln)
        num++
    }
}