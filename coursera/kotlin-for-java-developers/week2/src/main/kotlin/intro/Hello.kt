@file:JvmName("HelloKotlin")

package intro

fun main(args: Array<String>) {
    val name: String = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name!")

    val mutableList: MutableList<String> = mutableListOf("Testing Mutable")
    println(mutableList)

    val immutableList: List<String> = listOf("Testing Immutable")
    println(immutableList)

    println("Max: ${max(1, 2)}")

    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
    println(listOf('a', 'b', 'c').joinToString(postfix = "."))

    displaySeparator()
    displaySeparator('#')
    displaySeparator(size = 5)
    displaySeparator('#', 5)

    println("Sum no args: ${sum()}")
    println("Sum args: ${sum(1,2,3)}")
}

fun max(a: Int, b: Int): Int = maxOf(a, b)

@JvmOverloads
fun displaySeparator(character: Char = '*', size: Int = 10, postfix: Char = '\n') {
    repeat(size) {
        print(character)
    }
    print(postfix)
}

fun sum(a: Int = 0, b: Int = 0, c: Int = 0) : Int = a + b + c