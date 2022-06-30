package controlstructures.exceptions

import java.io.IOException

fun main(args: Array<String>) {
    val numberArg = if (args.isEmpty()) -1 else try {
        args[0].toInt()
    } catch (e: NumberFormatException) {
        -1
    }

    var percentage: Int = -1
    try {
        percentage =
            if (numberArg in 0..100) {
                numberArg
            } else {
                throw IllegalArgumentException("A percentage value must be between 0 and 100: $numberArg") // compiler says it gets assigned, but it doesn't, initial value is unchanged
            }
    } catch (e: Exception) {
        println("Inside catch: $percentage")
    }
    println("Outside catch: $percentage")
}

fun foo() {
    throw IOException()
}

@kotlin.jvm.Throws(IOException::class)
fun bar() {
    throw IOException()
}

