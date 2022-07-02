package mastermind

const val PLACEHOLDER: Char = '*'

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val guessList: MutableList<Char> = guess.toMutableList()
    val secretList: MutableList<Char> = secret.toMutableList()

    var rightPosition = 0
    var wrongPosition = 0

    for ((index: Int, char: Char) in guess.withIndex()) {
        if (secret[index] == char) {
            rightPosition++
            guessList[index] = PLACEHOLDER
            secretList[index] = PLACEHOLDER
        }
    }

    for (char: Char in guessList) {
        if (char != PLACEHOLDER && char in secretList) {
            wrongPosition++
            secretList.remove(char)
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
