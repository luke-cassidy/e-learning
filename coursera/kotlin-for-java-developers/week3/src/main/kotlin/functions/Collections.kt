package functions

fun main() {
    val list1 = listOf(0, 1, 2, 3, 4, 5, 6)
    println(list1.filter { it % 2 == 0 })
    println(list1.map { it * it })
    println(list1.any { it % 2 == 0 })
    println(list1.all { it % 2 == 0 })
    println(list1.none { it % 2 == 0 })
    println(list1.find { it % 2 == 0 })
    println(list1.first { it % 2 == 0 })
    println(list1.firstOrNull { it % 2 == 0 })
    println(list1.count { it % 2 == 0 })
    println(list1.partition { it % 2 == 0 })
    println(list1.groupBy { if (it % 2 == 0) "even" else "odd" })
    println(list1.associateBy { if (it % 2 == 0) "even" else "odd" })
    println(list1.associate { if (it % 2 == 0) "even" to it else "odd" to it })
    println(list1.associate { 'a' + it to 10 * it })

    val list2 = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
    println(list1.zip(list2))
    println(list1.zip(list2) { x, y -> x.toString().plus(y) })
    println(list1.zipWithNext())
    println(list1.zipWithNext { x, y -> x.toString().plus(y) })

    val listOfLists = listOf(list1, list2)
    println(listOfLists.flatten())
    println(list1.flatMap { 0..it })
}