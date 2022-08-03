package sequences.playground

import eq

fun fibonacciConcise(): Sequence<Int> = sequence {
    var elements = Pair(0, 1)
    while (true) {
        yield(elements.first)
        elements = Pair(elements.second, elements.first + elements.second)
    }
}

fun fibonacci(): Sequence<Int> = sequence {
    yield(0); yield(1)
    var nMinus2 = 0
    var nMinus1 = 1
    var temp: Int
    while (true) {
        yield(nMinus1 + nMinus2)
        temp = nMinus2
        nMinus2 = nMinus1
        nMinus1 += temp
    }
}

fun main(args: Array<String>) {
    fibonacciConcise().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacciConcise().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}