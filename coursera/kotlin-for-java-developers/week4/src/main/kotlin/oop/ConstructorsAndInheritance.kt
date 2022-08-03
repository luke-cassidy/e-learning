package oop;

class Animal(val name: String, val age: Int)

////////////////////////////////////////////////

interface Talkable {
    fun talk()
}

interface Walkable {
    fun walk()
}

open class Person(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
        println("primary constructor")
    }

    constructor(name: String) : this(name, 0) {
        println("new born constructor")
    }

    internal constructor() : this("Blank Slate") {
        println("blank slate constructor")
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

class TalkablePerson(name: String, age: Int) : Person(name, age), Talkable {
    init {
        println("talkable constructor")
    }

    override fun talk() {
        println("Hello, my name is $name. I am a person who can talk!")
    }
}

class WalkablePerson : Person, Walkable {
    constructor(name: String, age: Int) : super(name, age) {
        println("walkable constructor")
    }

    override fun walk() {
        println("Hello, my name is $name. I am a person who can walk!")
    }
}

fun main() {
    Person()
    Person("Luke")
    Person("Andrew", 26)

    TalkablePerson("Jerica", 26).talk()
    WalkablePerson("Jereni", 26).walk()
}