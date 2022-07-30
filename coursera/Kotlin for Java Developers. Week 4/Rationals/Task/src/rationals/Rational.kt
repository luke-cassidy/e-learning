package rationals

import java.math.BigInteger

// class definition
data class Rational internal constructor(
    private var numerator: BigInteger,
    private var denominator: BigInteger
) : Comparable<Rational> {
    private val quantifiedValue: BigInteger

    init {
        if (denominator == 0.toBigInteger()) {
            throw IllegalArgumentException("Denominator cannot be zero")
        }
        val gcd = numerator.gcd(denominator)
        this.numerator /= gcd
        this.denominator /= gcd
        this.quantifiedValue = numerator / denominator
    }


    override fun compareTo(other: Rational): Int {
        return (this.quantifiedValue - other.quantifiedValue).compareTo(0.toBigInteger())
    }

    // arithmetic operator functions
    operator fun plus(other: Rational): Rational {
        return Rational(
            this.numerator * other.denominator + other.numerator * this.denominator,
            this.denominator * other.denominator
        )
    }

    operator fun minus(other: Rational): Rational {
        return Rational(
            this.numerator * other.denominator - other.numerator * this.denominator,
            this.denominator * other.denominator
        )
    }

    operator fun times(other: Rational): Rational {
        return Rational(
            this.numerator * other.numerator,
            this.denominator * other.denominator
        )
    }

    operator fun div(other: Rational): Rational {
        return Rational(
            this.numerator * other.denominator,
            this.denominator * other.numerator
        )
    }

    operator fun unaryMinus(): Rational {
        return Rational(-this.numerator, this.denominator)
    }

    override fun toString(): String {
        return quantifiedValue.toString()
    }
}

// factory operators
infix fun Int.divBy(denominator: Int): Rational {
    return Rational(this.toBigInteger(), denominator.toBigInteger())
}

infix fun Long.divBy(denominator: Long): Rational {
    return Rational(this.toBigInteger(), denominator.toBigInteger())
}

infix fun BigInteger.divBy(denominator: BigInteger): Rational {
    return Rational(this, denominator)
}

// extension factory functions
fun String.toRational(): Rational {
    return this.split("/").let {
        val first = it[0].toBigInteger()
        val second = if (it.size < 2) 1.toBigInteger() else it[1].toBigInteger()
        Rational(first, second)
    }
}

fun Int.toRational(): Rational = Rational(this.toBigInteger(), 1.toBigInteger())

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}