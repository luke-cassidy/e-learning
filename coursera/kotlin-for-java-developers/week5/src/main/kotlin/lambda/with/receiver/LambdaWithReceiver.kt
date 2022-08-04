package lambda.with.receiver

fun main() {
    println("regular...")
    var sb = StringBuilder()
    sb.appendLine("Alphabet: ")
    for (c in 'a'..'z') {
        sb.append(c)
    }
    println(sb.toString())

    println("lambda with receiver...")
    sb = StringBuilder()
    sb.appendLine("Alphabet: ")
    with(sb) {
        this.appendLine("Alphabet: ")
        for (c in 'a'..'z') {
            this.append(c)
        }
    }
    println(sb.toString())

    println("build string...")
    val s: String = buildString {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
    }
    println(s)
}