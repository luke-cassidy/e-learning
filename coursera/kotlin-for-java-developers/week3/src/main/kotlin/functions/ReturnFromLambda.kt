package functions

fun main() {
    val list = listOf(3, 0, 5)
    println(duplicateNonZero(list))
    println(containsZero(list))
    println(duplicateNonZeroLabeled(list))
    println(duplicateNonZeroLocalFunction(list))
    println(duplicateNonZeroAnonymous(list))
}

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it, it)
    }
}

fun duplicateNonZeroLabeled(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf()
        listOf(it, it)
    }
}

fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int> {
    fun duplicateNonZeroElement(e: Int): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    }
    return list.flatMap(::duplicateNonZeroElement)
}

fun duplicateNonZeroAnonymous(list: List<Int>): List<Int> {
    return list.flatMap(fun(e): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    })
}

fun containsZero(list: List<Int>): Boolean {
    list.forEach { if (it == 0) return true }
    return false
}
