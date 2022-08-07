package board

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

open class SquareBoardImpl(final override val width: Int) : SquareBoard {
    private val cells: Array<Array<Cell>> = Array(width) { i -> Array(width) { j -> Cell(i + 1, j + 1) } }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return try {
            this.cells[i - 1][j - 1]
        } catch (e: ArrayIndexOutOfBoundsException) {
            null
        }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return try {
            this.cells[i - 1][j - 1]
        } catch (e: ArrayIndexOutOfBoundsException) {
            throw IllegalArgumentException(e)
        }
    }

    override fun getAllCells(): Collection<Cell> {
        return this.cells.flatten()
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        return jRange.mapNotNull {
            try {
                this.cells[i - 1][it - 1]
            } catch (e: ArrayIndexOutOfBoundsException) {
                null
            }
        }
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        return iRange.mapNotNull {
            try {
                this.cells[it - 1][j - 1]
            } catch (e: ArrayIndexOutOfBoundsException) {
                null
            }
        }
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return try {
            when (direction) {
                Direction.UP -> this@SquareBoardImpl.cells[i - 2][j - 1]
                Direction.DOWN -> this@SquareBoardImpl.cells[i][j - 1]
                Direction.LEFT -> this@SquareBoardImpl.cells[i - 1][j - 2]
                Direction.RIGHT -> this@SquareBoardImpl.cells[i - 1][j]
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            null
        }
    }

}

class GameBoardImpl<T>(width: Int) : GameBoard<T>, SquareBoardImpl(width) {
    private val values: MutableMap<Cell, T?> = mutableMapOf()
    override operator fun get(cell: Cell): T? {
        return this.values[cell]
    }

    override operator fun set(cell: Cell, value: T?) {
        this.values[cell] = value
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return this.getAllCells().map { this.values[it] }.all(predicate)
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return this.getAllCells().map { this.values[it] }.any(predicate)
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return this.getAllCells().find { cell -> predicate(this.values.getOrDefault(cell, null)) }
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return this.getAllCells().filter { cell -> predicate(this.values.getOrDefault(cell, null)) }
    }

}