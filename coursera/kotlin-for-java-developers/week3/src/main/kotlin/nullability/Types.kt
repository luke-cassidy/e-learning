package nullability

fun main() {
    val list1: List<Int?> = listOf(1, null, 2)
    val list2: List<Int>? = null
    foo(list1, list2)
}

fun foo(list1: List<Int?>, list2: List<Int>?) {
    println(list1.size)
    println(list2?.size)

    val i: Int? = list1[0]
    val j: Int? = list2?.get(0)

    println(i)
    println(j)
}