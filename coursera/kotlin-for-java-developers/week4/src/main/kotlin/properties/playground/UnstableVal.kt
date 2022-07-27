package properties.playground

var ref: Int = 0

val foo: Int
    get() = ref++

fun main(args: Array<String>) {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}