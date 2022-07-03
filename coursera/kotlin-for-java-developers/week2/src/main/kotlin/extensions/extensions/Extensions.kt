package extensions.extensions

fun main() {
    println("${"test".last()}")
    println("${"test".lastChar()}")
    println("test" repeat 5)
}

fun String.lastChar() = get(length - 1)

infix fun String.repeat(n: Int): String {
    val sb = StringBuilder(n * length)
    repeat(n) { sb.append(this) }
    return sb.toString()
}