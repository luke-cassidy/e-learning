package nullability.safecasts

fun main() {

    val any: Any = "Hello"
    if(any is String) {
        val string = any as String
        println(string.toUpperCase())
    }

    if(any is String) {
        println(any.toUpperCase())
    }

    println("${(any as? String)?.toUpperCase()}")
}