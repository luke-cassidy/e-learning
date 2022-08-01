package library.functions

import properties.FacebookUser
import properties.Session
import properties.User
import kotlin.random.Random

val foo = run { println("Calculating foo.."); "foo" }

class Email(val address: String)

fun getEmail(): Email? = if (Random.nextBoolean()) Email("anEmailAddress@email.com") else null

fun analyzeUserSession(session: Session) = (session.user as? FacebookUser)?.let { println(it.accountId) }

fun main() {
    println(foo)

    getEmail()?.let { println(it.address) }

    val session = object : Session {
        override val user: User = FacebookUser(1234)
    }

    analyzeUserSession(session)

    val list = listOf(1, 2, 3, 4, 5, 6)
    list.random().takeIf { it % 2 == 0 }?.let { println(it) } ?: println("receiver was null")

    val rnd = Random.nextInt(10)
    list.filter { it > rnd }.takeIf(List<Int>::isNotEmpty)?.let { println("takeIf: $it") }
    list.filter { it > rnd }.takeUnless(List<Int>::isNullOrEmpty)?.let { println("takeUnless: $it") }

    repeat(10) { println("Welcome!") }

}