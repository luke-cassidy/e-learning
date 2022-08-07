package games.gameOfFifteen

import board.Cell
import board.Direction
import board.GameBoard
import board.GameBoardImpl
import games.game.Game
import kotlin.random.Random

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
    GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board: GameBoard<Int> = GameBoardImpl(4)

    override fun initialize() {
        val permutationsWithSpace: MutableList<Int?> = initializer.initialPermutation.toMutableList()
        permutationsWithSpace.forEachIndexed { index, value ->
            board[Cell((index / 4) + 1, (index % 4) + 1)] = value
        }
    }

    override fun canMove(): Boolean {
        return true
    }

    override fun hasWon(): Boolean {
        var lastValue = 0
        for (cell in board.getAllCells()) {
            val currValue = board[cell] ?: continue
            if ((currValue - lastValue) == 1) {
                lastValue = currValue
            } else {
                return false
            }
        }
        return true
    }

    override fun processMove(direction: Direction) {
        val cell = board.find { it == null }!!
        val neighbour = with(board) {
            cell.getNeighbour(direction.reversed())
        }
        neighbour?.let { val temp = board[cell]; board[cell] = board[it]; board[it] = temp }
    }

    override fun get(i: Int, j: Int): Int? {
        return board[Cell(i, j)]
    }
}