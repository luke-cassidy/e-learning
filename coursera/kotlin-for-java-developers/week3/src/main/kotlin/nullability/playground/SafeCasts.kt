package nullability.playground

fun main(args: Array<String>) {
    val s = "myString"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}