package functions

fun main() {
    val people = listOf(
        Person("Amy", 20),
        Person("Jack", 30)
    )

    println(people.maxByOrNull { it.age })
    println(people.maxByOrNull(Person::age))

//    val predicate = isEven // compile error
    var predicate: (Int) -> Boolean = ::isEven
    predicate = { i: Int -> isEven(i) } //equivalent

    var action: (Person, String) -> Unit = ::sendEmail
    action = { person: Person, message: String -> sendEmail(person, message) }

    val list = listOf(1, 2, 3, 4)
    println(list.any(::isEven))
    println(list.filter(::isEven))

    val unboundAgePredicate: (Person, Int) -> Boolean = Person::isOlder
    val alice = Person("Alice", 29)
    println(unboundAgePredicate(alice, 21))
    val boundAgePredicate: (Int) -> Boolean = alice::isOlder
    println(boundAgePredicate(21))
}

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
    fun getAgePredicate() = this::isOlder
}

fun isEven(i: Int): Boolean = i % 2 == 0

fun sendEmail(person: Person, message: String) {
    println("To: ${person.name}\n$message")
}