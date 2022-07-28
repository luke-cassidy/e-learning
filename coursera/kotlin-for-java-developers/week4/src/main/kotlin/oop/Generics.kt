package oop

fun main() {
    val intList: List<Int> = listOf(1, 2, 3)
    val nullableIntList: List<Int?> = listOf(1, 2, null)
    println(nullableFoo(intList))
    println(nullableFoo(nullableIntList))

    println(nonNullableFoo(intList))
//    println(nonNullableFoo(nullableIntList)) // will not compile as T cannot be nullable

    val doubleList: List<Double> = listOf(1.0, 2.0, 3.0)
    println(numberFoo(intList))
    println(numberFoo(doubleList))

    val nullableDoubleList: List<Double?> = listOf(1.0, 2.0, null)
//    println(numberFoo(nullableDoubleList)) // won't compile as upperbound is not nullable
    println(nullableNumberFoo(nullableDoubleList))

    println(max(1, 2))

    println(ensureTrailingPeriod(StringBuilder("aString")))

    println(intList.average())
    println(doubleList.average())
}

// T can be nullable
fun <T> nullableFoo(list: List<T>): T {
    return list.last()
}

// T cannot be nullable
fun <T : Any> nonNullableFoo(list: List<T>): T {
    return list.last()
}

// T must be a subtype of Number
fun <T : Number> numberFoo(list: List<T>): T {
    return list.last()
}

// T must be a subtype of Number
fun <T : Number?> nullableNumberFoo(list: List<T>): T {
    return list.last()
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T): T where T : CharSequence, T : Appendable { // use where to declare multiple upperbounds
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
    return seq
}

fun List<Int>.average(): Double {
    return this.sum() / this.size.toDouble()
}

@JvmName("averageOfDouble") //need to so that there is no conflict in method signatures at bytecode level
fun List<Double>.average(): Double {
    return this.sum() / this.size.toDouble()
}