package playground

class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main(args: Array<String>) {
    val a = A()
    try {
        a.display()
    } catch (e: UninitializedPropertyAccessException) {
        println("UninitializedPropertyAccessException: ${e.message}")
    }
    a.setUp()
    a.display()
}