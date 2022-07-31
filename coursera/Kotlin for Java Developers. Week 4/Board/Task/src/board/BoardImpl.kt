package board

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

class SquareBoardImpl(override val width: Int) : SquareBoard {
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
