package conventions

data class Board constructor(
    val size: Int,
    private val board: Array<Array<Char?>> = Array(size) { Array(size) { null } }
) {

    operator fun get(x: Int): Array<Char?> {
        return this.board[x]
    }

    operator fun get(x: Int, y: Int): Char? {
        return this.board[x][y]
    }

    operator fun set(x: Int, y: Int, value: Char) {
        this.board[x][y] = value
    }

    // data methods

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        if (size != other.size) return false
        if (!board.contentDeepEquals(other.board)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size
        result = 31 * result + board.contentDeepHashCode()
        return result
    }

    override fun toString(): String {
        return "Board(size=$size, board=${board.contentDeepToString()})"
    }
}

data class Contact(
    val name: String,
    val email: String,
    val phoneNumber: String
) {
    // component methods for constructor val arguments will be generated automatically at compile time
}

fun main() {
    // multi arg syntax thanks to operator getter and setters with x and y params
    val board = Board(5)
    board[0, 0] = 'a'
    board[0, 1] = 'b'
    println(board[0, 0])
    println(board[0, 1])

    // multidimensional syntax thanks to operator getter with x param only
    board[1][0] = 'c'
    board[1][1] = 'd'
    println(board[1][0])
    println(board[1][1])

    println(board)

    val (name, email, number) = Contact(
        "Luke",
        "luke@luke.com",
        "1234"
    ) // destructing syntax works for members of data classes
    println("$name, $email, $number")
}
