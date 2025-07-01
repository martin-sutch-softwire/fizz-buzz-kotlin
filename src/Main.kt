fun main() {
    inputRules()
}

data class Rule(
    val description: String,
    var isEnabled: Boolean,
)

val rules = mutableMapOf(
    "3" to Rule("Fizz every 3rd number.", true),
    "5" to Rule("Buzz every 5th number.", true),
    "7" to Rule("Bang every 7th number.", true),
    "11" to Rule("Bong every 11th number, replacing any Fizz/Buzz/Bang.", true),
    "13" to Rule("Fezz every 13th number, before the first B-word (otherwise at end).", true),
    "17" to Rule("Every 17th number reverse the order of the words.", true)
)

fun toggleRule(ruleKey: String) {
    rules[ruleKey]?.let {
        it.isEnabled = !it.isEnabled
    }
}

fun inputRules() {
    println("RULES:")
    for ((key, rule) in rules) {
        println("${if (rule.isEnabled) "\uD83D\uDDF9 | " else "☐ | "}Type '${key}' to ${if (rule.isEnabled) "remove" else "add"} rule: ${rule.description}")
    }
    println("Then press enter to continue.")
    val ruleInput = readln().toIntOrNull()
    if (ruleInput is Int) {
        toggleRule(ruleInput.toString())
        inputRules()
    } else inputLimit()
}

fun inputLimit() {
    println("And how far are we going? Give us a number...")
    val limit = readln().toIntOrNull()
    if (limit is Int) fizzBuzz(limit) else inputLimit()
}

fun fizzBuzz(limit: Int) {
    for (num in 1..limit) {
        var output =
            buildString {
                if (rules["11"]!!.isEnabled && num % 11 == 0) append("Bong") else {
                    if (rules["3"]!!.isEnabled && num % 3 == 0) append("Fizz")
                    if (rules["5"]!!.isEnabled && num % 5 == 0) append("Buzz")
                    if (rules["7"]!!.isEnabled && num % 7 == 0) append("Bang")
                }
                if (rules["13"]!!.isEnabled && num % 13 == 0) {
                    val index = indexOf("B").takeIf { it != -1 } ?: count()
                    insert(index, "Fezz")
                }
            }
        if (rules["17"]!!.isEnabled && num % 17 == 0) {
            val words = output.split("(?=[A-Z])".toRegex())
            output = words.reversed().joinToString("")
        }
        if (output == "") output = num.toString()
        println(output)
    }
    inputRules()
}