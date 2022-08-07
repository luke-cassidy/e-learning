package games.gameOfFifteen

import kotlin.random.Random

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialized the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        val permutation: MutableList<Int> = (1..15).shuffled().toMutableList()
        while (!isEven(permutation)) {
            val swapIndexes = Pair(Random.nextInt(permutation.lastIndex), Random.nextInt(permutation.lastIndex))
            val temp = permutation[swapIndexes.first]
            permutation[swapIndexes.first] = permutation[swapIndexes.second]
            permutation[swapIndexes.second] = temp
        }
        permutation
    }
}

