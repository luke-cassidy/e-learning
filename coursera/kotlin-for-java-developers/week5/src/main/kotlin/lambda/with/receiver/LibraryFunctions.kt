package lambda.with.receiver

import kotlin.random.Random

class Window {
    var height: Int = 0
    var width: Int = 0
    var isVisible: Boolean = false

    override fun toString(): String {
        return "Window(height=$height, width=$width, isVisible=$isVisible)"
    }
}

fun main() {
    val window = Window()
    println(window)
    with(window) {
        height = 300
        width = 200
        isVisible = true
    }
    println(window)

    val windowOrNull = if (Random.nextBoolean()) Window() else null
    windowOrNull?.run {
        height = 300
        width = 200
        isVisible = true
    }
    println(windowOrNull)

    val window2 = Window().apply {
        height = 300
        width = 200
        isVisible = true
    }.also {
        println("in also, this will still return Window -> $it")
    }
    println(window2)

}
