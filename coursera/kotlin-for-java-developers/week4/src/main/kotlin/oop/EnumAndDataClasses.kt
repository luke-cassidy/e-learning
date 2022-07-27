package oop

enum class Colour(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255), ORANGE(255, 165, 0), RED(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getDescription(colour: Colour) =
    when (colour) {
        Colour.BLUE -> "cold"
        Colour.ORANGE -> "warm"
        Colour.RED -> "hot"
    }

data class Contact(val name: String, val address: String)

class Foo(val first: Int, val second: Int)

data class Bar(val first: Int, val second: Int) {
    override fun equals(other: Any?): Boolean {
        // can override and add custom equals
        return super.equals(other)
    }

    override fun hashCode(): Int {
        // can override and add custom hashCode
        return super.hashCode()
    }
}

data class User internal constructor(val email: String) {
    var nickname: String? =
        null // will not be included in generated data methods because it isn't in primary constructor

    constructor(email: String, nickname: String) : this(email) {
        this.nickname = nickname
    }
}

fun main() {
    println(getDescription(Colour.BLUE))
    println(getDescription(Colour.ORANGE))
    println(getDescription(Colour.RED))

    println(Colour.BLUE.rgb())
    println(Colour.ORANGE.rgb())
    println(Colour.RED.rgb())

    val luke = Contact("Luke", "London")
    val jerica = luke.copy(name = "Jerica")

    println(luke.toString())
    println(luke.hashCode())
    println(luke == luke) // data equality
    println(luke === luke) // reference equality
    println(luke == jerica) // data equality
    println(luke === jerica) // reference equality

    val lukeClone = luke.copy()
    println(luke == lukeClone) // data equality
    println(luke === lukeClone) // reference equality

    val f1 = Foo(1, 2)
    val f2 = Foo(1, 2)
    println(f1 == f2) // false as it is not a data class, so reference equality is used
    val f3 = f1
    println(f1 == f3) // true cause reference points to exact same object

    val user1 = User("person@email.com", "luke")
    println(user1)

    val user2 = User("person@email.com", "jerica")
    println(user2)

    println(user1 == user2) // equal as nickname not included in data generated methods
}