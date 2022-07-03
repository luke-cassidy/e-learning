package controlstructures.ranges

fun main() {
    var char = 'A'
    println("$char is ${recognize(char)}")
    char = 'g'
    println("$char is ${recognize(char)}")
    char = '1'
    println("$char is ${recognize(char)}")
    char = '$'
    println("$char is ${recognize(char)}")

    val stringRange: ClosedRange<String> = "ab".."az"
    println("stringrange type: ${stringRange::class}")
    println("Is \"ac\" in ${stringRange}: ${"ac" in stringRange}")
    println("Is \"abcdefghijklmnopqrsuvwxyz0123456789\" in ${stringRange}: ${"abcdefghijklmnopqrsuvwxyz0123456789" in stringRange}")
    println("Is \"bc\" in ${stringRange}: ${"bc" in stringRange}")

    val intRange: IntRange = 1..10
    println("intRange elements: ${intRange.joinToString(prefix = "(", separator = ",", postfix = ")")}")

    val myDateRange: ClosedRange<MyDate> = MyDate(-10)..MyDate(10)
    val myDate = MyDate(0)
    println("Is MyDate $myDate in ${myDateRange}: ${myDate in myDateRange}")
}

fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char): Boolean = c !in '1'..'9'

fun recognize(c: Char) = when {
    !isNotDigit(c) -> "It's a digit!"
    isLetter(c) -> "It's a letter!"
    else -> "I don't know..."
}

data class MyDate(private val date: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = this.date - other.date
}