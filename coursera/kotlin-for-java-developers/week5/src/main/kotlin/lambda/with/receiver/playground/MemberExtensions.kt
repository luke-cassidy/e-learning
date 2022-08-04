package lambda.with.receiver.playground

import eq

class Words {
    private val list = mutableListOf<String>()

    internal fun String.record() {
        list += this
    }

    internal operator fun String.unaryPlus() {
        record()
    }

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}