package library.functions

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun <R> myRun(block: () -> R) = block()

inline fun <R> myRunInlined(block: () -> R) = block()

fun main() {
    myRun { println("myRun()") }
    myRunInlined { println("myRunInlined()") }

    val myObject = Object()
    synchronized(myObject) {
        println("executing this block of code inside the synchronized block")
    }

    val lock = ReentrantLock()
    lock.withLock { println("executing this block of code protected by the lock") }

    BufferedReader(FileReader("./week5/src/main/resources/test.csv")).use { println(it.readLine()) } // equivalent of try with resource
}