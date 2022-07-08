package functions

fun main() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    println("${sum(1, 2)}")

    val isPositive = { i: Int -> i > 0 }
    val numbers: List<Int> = listOf(-1, 0, 1)
    println(numbers.any(isPositive))
    println(numbers.any({ i: Int -> i > 0 }))
    println(numbers.any { i: Int -> i > 0 })
    println(numbers.any { i -> i > 0 })
    println(numbers.any { it > 0 })
    println(numbers.any {
        println("processing $it")
        it > 0
    })

    val numbersMap = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    println(numbersMap.mapValues { entry -> "${entry.key} -> ${entry.value}!" })
    println(numbersMap.mapValues { (key, value) -> "$key -> $value!" })
    println(numbersMap.mapValues { (_, value) -> "$value!" })

}

