package controlstructures.conditonals

fun main() {
    println("max2: ${max(4, 6)}")

    val colour: Colour = Colour.RED
    println("Colour: ${colour}, ${getDescription(colour)}")

    var input = "yes"
    println("Question: Do you agree?, Reply: ${input}, Result: ${respondToInput(input)}")
    input = "Y"
    println("Question: Do you agree?, Reply: ${input}, Result: ${respondToInput(input)}")
    input = "No"
    println("Question: Do you agree?, Reply: ${input}, Result: ${respondToInput(input)}")
    input = "n"
    println("Question: Do you agree?, Reply: ${input}, Result: ${respondToInput(input)}")
    input = "duh?"
    println("Question: Do you agree?, Reply: ${input}, Result: ${respondToInput(input)}")

    val c1 = Colour.BLUE
    val c2 = Colour.RED
    println("Mixed colours, $c1, $c2: ${mix(c1, c2)}")

    println("Dog goes: ${Dog().woof()}")
    println("Cat goes: ${Cat().meow()}")
    println("My fav pet goes: ${getSound()}")

    println(updateWeather(0))
    println(updateWeather(10))
    println(updateWeather(50))
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

enum class Colour {
    RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE
}

fun getDescription(colour: Colour): String = when (colour) {
    Colour.RED -> "hot"
    Colour.BLUE -> "cold"
    Colour.ORANGE -> "warm"
    else -> throw UnsupportedOperationException("No description mapping for colour $colour")
}

fun respondToInput(input: String): String = when (input.toLowerCase()) {
    "y", "yes" -> "I'm glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I don't understand"
}

fun mix(c1: Colour, c2: Colour): Colour = when (setOf(c1, c2)) {
    setOf(Colour.RED, Colour.YELLOW) -> Colour.ORANGE
    setOf(Colour.YELLOW, Colour.BLUE) -> Colour.GREEN
    setOf(Colour.BLUE, Colour.RED) -> Colour.PURPLE
    else -> throw Exception("Dirty Colour")
}

fun getSound(): String = when (val pet = getMyFavoritePet()) {
    is Cat -> pet.meow()
    is Dog -> pet.woof()
    else -> "___"
}

fun getMyFavoritePet(): Pet {
    return Dog()
}

fun updateWeather(degrees: Int): String {
    val (description : String, colour: Colour) = when {
        degrees < 5 -> "cold" to Colour.BLUE
        degrees < 23 -> "mild" to Colour.ORANGE
        else -> "hot" to Colour.RED
    }
    return "it is $colour $description"
}

// type definitions

interface Pet

class Cat : Pet {
    fun meow(): String = "meow"
}

class Dog : Pet {
    fun woof(): String = "woof"
}