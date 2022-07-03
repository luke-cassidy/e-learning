package extensions.playground

// original definition
fun sumOriginal(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}

// extension definition
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main() {
    val sumOriginal = sumOriginal(listOf(1, 2, 3))
    println(sumOriginal)    // 6

    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}