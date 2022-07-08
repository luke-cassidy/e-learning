package functions

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })
    println(list.any { it % 2 == 0 })
    println(list.all { it % 2 == 0 })
    println(list.none { it % 2 == 0 })
    println(list.find { it % 2 == 0 })
    println(list.first { it % 2 == 0 })
    println(list.firstOrNull { it % 2 == 0 })
    println(list.count { it % 2 == 0 })
}