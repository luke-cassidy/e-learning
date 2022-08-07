package games.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 */
fun isEven(permutation: List<Int>): Boolean {
    var invertedPairs = 0
    for (i in 0..permutation.lastIndex) {
        for (j in (i + 1)..permutation.lastIndex) {
            if (permutation[i] > permutation[j]) {
                invertedPairs++
            }
        }
    }
    return invertedPairs % 2 == 0
}