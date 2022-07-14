package functions.quiz

val heroes = listOf(
    Hero("The Captain", 60, Gender.MALE),
    Hero("Frenchy", 42, Gender.MALE),
    Hero("The Kid", 9, null),
    Hero("Lady Lauren", 29, Gender.FEMALE),
    Hero("First Mate", 29, Gender.MALE),
    Hero("Sir Stephen", 37, Gender.MALE)
)

fun main() {
    println(heroes.last().name)
    println(heroes.firstOrNull { it.age == 30 }?.name)
    try {
        println(heroes.first { it.age == 30 }.name)
    } catch (e: NoSuchElementException) {
        println("NoSuchElementException thrown")
    }
    println(heroes.map { it.age }.distinct().size)
    println(heroes.filter { it.age < 30 }.size)
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println(youngest)
    println(oldest)
    println(oldest.size)
    println(heroes.maxByOrNull { it.age }?.name)
    println(heroes.all { it.age < 50 })
    println(heroes.any { it.gender == Gender.FEMALE })
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println(age)
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName.getOrElse("unknown") { unknownHero }.age)
    val ageByName = heroes.associate { it.name to it.age }
    println(ageByName.getOrElse("unknown") { 0 })
    val (first, second) = heroes.flatMap { heroes.map { hero -> it to hero } }
        .maxByOrNull { it.first.age - it.second.age }!!
    println(first.name)
}

data class Hero(val name: String, val age: Int, val gender: Gender?)

enum class Gender {
    MALE, FEMALE
}