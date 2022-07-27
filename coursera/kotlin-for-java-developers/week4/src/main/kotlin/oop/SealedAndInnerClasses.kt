package oop

fun main() {
    val result = eval(Sum(Num(1), Sum(Num(2), Num(3))))
    println(result)

    val resultSealed = eval(SumSealed(NumSealed(1), SumSealed(NumSealed(2), NumSealed(3))))
    println(resultSealed)

    val a = A(1)
    val b = A.B(2)
    val c = a.C(3)

    val repository = object : Repository {
        override fun getById(id: Int): Customer = Customer(id)
        override fun getAll(): List<Customer> = emptyList()
    }

    val logger = object : Logger {
        override fun logAll() = println("log")
    }

    val controller = Controller(repository, logger)
    // all method implementations available through delegate instances
    println(controller.getById(1))
    println(controller.getAll())
    controller.logAll()
}

interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression type")
    }

sealed class ExprSealed // restricts class hierarchy

// all subclasses must be located in the same file
class NumSealed(val value: Int) : ExprSealed()
class SumSealed(val left: ExprSealed, val right: ExprSealed) : ExprSealed()

fun eval(expr: ExprSealed): Int =
    when (expr) {
        is NumSealed -> expr.value
        is SumSealed -> eval(expr.left) + eval(expr.right)
    }

class A(val testInt: Int) {
    init {
        println("A:" + this.testInt)
    }

    class B(val testInt: Int) {
        init {
            println("B:" + this.testInt)
        }
    }

    inner class C(val testInt: Int) {
        init {
            println("A:" + this@A.testInt)
            println("C:" + this.testInt)
        }
    }
}

data class Customer(private val id: Int)

interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

class Controller(
    private val repository: Repository,
    private val logger: Logger
) : Repository by repository, Logger by logger // delegate implementation to these instances