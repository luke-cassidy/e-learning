package sequences.library.functions

import oop.Person

fun main() {
    val people = listOf(
        Person("Jerica", 26),
        Person("Luke", 29),
        Person("Ran", 18),
        Person("Dom", 20)
    )

    // 1.
    println(people.filter { it.age < 21 }.size) // verbose
    println(people.count { it.age < 21 })  // concise

    // random tangent on java streams
    println("before stream definition")
    val peopleStream = people.stream().filter { println("in stream.filter()"); it.age < 21 }
    println("after stream definition")
    println(peopleStream.count())

    // 2.
    println(people.sortedBy { it.age }.reversed()) // verbose
    println(people.sortedByDescending { it.age }) // concise

    // 3.
    println(people.map { person ->
        person.takeIf { it.age > 21 }?.name
    }.filterNotNull()) // verbose
    println(people.mapNotNull { person ->
        person.takeIf { it.age > 21 }?.name
    }) // concise

    // 4.
    var map = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        if (person.age !in map) {
            map[person.age] = mutableListOf()
        }
        map.getValue(person.age) += person // verbose
    }
    println(map)

    map = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        map.getOrPut(person.age) { mutableListOf() } += person // concise
    }
    println(map)

    // 5.
    map = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        if (person.age !in map) {
            map[person.age] = mutableListOf()
        }
        map.getValue(person.age) += person // verbose
    }
    println(map)

    println(people.groupBy { it.age }) // concise

    // 6.

    println(people.asSequence().groupBy { it.age }.mapValues { (_, group) -> group.size }) // eager grouping
    println(people.asSequence().groupingBy { it.age }.eachCount()) // lazy grouping
}