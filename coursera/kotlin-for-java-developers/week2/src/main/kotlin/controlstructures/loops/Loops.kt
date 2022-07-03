package controlstructures.loops

fun main() {
    val list = listOf("a", "b", "c")
    for (s in list) {
        print(s)
    }

    println()

    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    for (i in 1..9) {
        print(i)
    }

    println()

    for (i in 1 until 9) {
        print(i)
    }

    println()

    for (i in 9 downTo 1 step 2) {
        print(i)
    }

    println()

    for (ch in "abc") {
        print(ch + 1)
    }

    println()

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    for ((key, value) in map) {
        println("$key = $value")
    }
}