package extensions.stdlib

fun main() {
    val set = hashSetOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    //String
    var q = """To code,
        or not to code?.."""
    println(q)
    q = """To code,
        or not to code?..""".trimMargin()
    println(q)
    q = """To code,
        |or not to code?..""".trimMargin()
    println(q)
    q = """To code,
        #or not to code?..""".trimMargin(marginPrefix = "#")
    println(q)
    q = """
        Keep calm
        and learn Kotlin""".trimIndent()
    println(q)

    var regex = "\\d{2}\\.\\d{2}\\.\\d{4}".toRegex()
    println(regex.matches("15.02.2016"))
    println(regex.matches("15.02.16"))
    regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()
    println(regex.matches("15.02.2016"))
    println(regex.matches("15.02.16"))
}