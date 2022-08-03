package sequences

import java.math.BigInteger
import kotlin.random.Random

fun main() {
    fun m(i: Int): Int {
        print("m$i")
        return i
    }

    fun f(i: Int): Boolean {
        print("f$i")
        return i % 2 == 0
    }

    val list = listOf(1, 2, 3, 4)

    println("collections vs sequences")
    println("collection")
    list.map(::m).filter(::f)

    println("\nsequence used")
    list.asSequence().map(::m).filter(::f).toList()

    println("\nsequence not used")
    // this doesn't actually evaluate anything because a terminal operation, e.g. toList() is not called for this sequence
    list.asSequence().map(::m).filter(::f)

    println("sequences operation order")

    println("\nmap first")
    list.asSequence().map(::m).filter(::f).toList()

    println("\nfilter first")
    list.asSequence().filter(::f).map(::m).toList()

    println()
    val seq = generateSequence { Random.nextInt(5).takeIf { it > 0 } }
    println(seq.toList())

    // will wait for exit on std input
    val input = generateSequence { readLine().takeUnless { it == "exit" } }
    println(input.toList())

    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())

    val bigNumbers = generateSequence(BigInteger.ZERO) { it + BigInteger.ONE }
    println(bigNumbers.take(5).toList())

    val moreNumbers = generateSequence(3) { n ->
        println("Generating Element...")
        (n + 1).takeIf { it < 7 }
    }

    println("first()")
    println(moreNumbers.first())
    println("toList()")
    println(moreNumbers.toList())

    val evenMoreNumbers = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }

    println(evenMoreNumbers.take(5).toList())

    fun mySequence() = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(3..5)
        println("yield a list")
        yieldAll(listOf(7, 9))
    }

    println(mySequence()
        .map { it * it }
        .filter { it > 10 }
        .take(1))

    println(mySequence()
        .map { it * it }
        .filter { it > 10 }
        .first())
}