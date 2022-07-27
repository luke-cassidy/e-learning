package oop

fun main() {
    KSingleton.foo()

    val window = Window()
    println(window.mouseAdaptors.size)

    window.addMouseListener(object : MouseAdaptor {
        override fun mouseClicked() {
            println("mouse clicked")
        }

        override fun mouseEntered() {
            println("mouse entered")
        }
    })

    println(window.mouseAdaptors.size)
    window.mouseAdaptors.forEach {
        it.mouseClicked()
        it.mouseEntered()
    }

    println(window.keyboardAdaptors.size)

    window.addKeyboardListener(object : KeyboardAdaptor {
        override fun keyPressed() {
            println("key pressed")
        }
    })

    println(window.keyboardAdaptors.size)
    window.keyboardAdaptors.forEach {
        it.keyPressed()
    }

    println(CompanionTest.foo())
    println(CompanionTest.bar())
    println(CompanionTest.create().foobar())
    println(CompanionTest.fooBar())
}

object KSingleton {
    fun foo() {
        println("foo")
    }
}

interface MouseAdaptor {
    fun mouseClicked()
    fun mouseEntered()
}

interface KeyboardAdaptor {
    fun keyPressed()
}

class Window {
    val mouseAdaptors: MutableList<MouseAdaptor> = mutableListOf()
    val keyboardAdaptors: MutableList<KeyboardAdaptor> = mutableListOf()

    fun addMouseListener(listener: MouseAdaptor) {
        mouseAdaptors += listener
    }

    fun addKeyboardListener(listener: KeyboardAdaptor) {
        keyboardAdaptors += listener
    }
}

interface Factory<T> {
    fun create(): T
}

class CompanionTest private constructor() {
    companion object : Factory<CompanionTest> {
        override fun create(): CompanionTest {
            return CompanionTest()
        }

        @JvmStatic
        fun foo() = 1
        fun bar() = 2
    }

    fun foobar() = foo() + bar()
}

fun CompanionTest.Companion.fooBar() = this.create().foobar() * 2