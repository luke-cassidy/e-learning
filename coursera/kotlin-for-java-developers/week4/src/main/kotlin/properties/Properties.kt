package properties

import properties.Properties.ContactJava
import properties.Properties.PersonJava

fun main() {
    val contactKotlin = ContactKotlin("Luke", "London")
    println("Contact: ${contactKotlin.name}, lives in: ${contactKotlin.address}")

    val contactJava = ContactJava("Luke", "London")
    println("Contact: ${contactJava.name}, lives in: ${contactJava.address}")

    val personKotlin = PersonKotlin("Luke", 29)
    println("Person: ${personKotlin.name}, is: ${personKotlin.age}")

    val personJava = PersonJava("Luke", 29)
    println("Person: ${personJava.name}, is: ${personJava.age}")

    val rectangle = Rectangle(2, 3)
    println(rectangle.isSquare)

    println("$foo1 $foo1 $foo2 $foo2")

    val stateLogger = StateLogger()
    println(stateLogger.state)
    stateLogger.state = true
    println(stateLogger.state)

    val lengthCounter = LengthCounter()
    println(lengthCounter.counter)
    lengthCounter.addWord("Luke")
    println(lengthCounter.counter)
}

class ContactKotlin(val name: String, val address: String)

class PersonKotlin(val name: String, var age: Int)

class Rectangle(val height: Int, var width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

val foo1 = run {
    println("Calculating the answer...")
    42
}

val foo2: Int
    get() {
        println("Calculating the answer...")
        return 42
    }

class StateLogger {
    var state = false
        set(value) {
            println("state had changed: $field -> $value")
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}
