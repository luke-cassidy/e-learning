package functions

fun main() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val isEven = { i: Int -> i% 2 == 0 }
    val result = isEven(42)
    println(result)

    val list = listOf(1,2,3,4)
    println(list.any(isEven))
    println(list.filter(isEven))

    run { println("hey!") }

    FunctionTypes.postponeComputation(1000) { println(42) }
    val runnable = Runnable { println(42) }
    FunctionTypes.postponeComputation(1000, runnable)

    val f: (() -> Int)? = null

    if (f != null) {
        f()
    }

    f?.invoke()
}