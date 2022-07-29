package conventions

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point): Point = Point(this.x + other.x, this.y + other.y)
operator fun Point.minus(other: Point): Point = Point(this.x - other.x, this.y - other.y)
operator fun Point.times(other: Point): Point = Point(this.x * other.x, this.y * other.y)
operator fun Point.div(other: Point): Point = Point(this.x / other.x, this.y / other.y)
operator fun Point.rem(other: Point): Point = Point(this.x % other.x, this.y % other.y)

// args and receiver times do not need to match
operator fun Point.times(scale: Int): Point = Point(this.x * scale, this.y * scale)


// unary operator overloads
operator fun Point.unaryPlus(): Point = Point(+this.x, +this.y)
operator fun Point.unaryMinus(): Point = Point(-this.x, -this.y)
operator fun Point.not(): Point = Point((-1 xor this.x) + 1, this.y.inv() + 1)
operator fun Point.inc(): Point = Point(this.x + 1, this.y + 1)
operator fun Point.dec(): Point = Point(this.x - 1, this.y - 1)

fun main() {
    println(Point(1, 2).plus(Point(2, 1)))
    println(Point(1, 2) + Point(2, 1))
    println(Point(1, 2).minus(Point(2, 1)))
    println(Point(1, 2) - Point(2, 1))
    println(Point(1, 2).times(Point(2, 1)))
    println(Point(1, 2) * Point(2, 1))
    println(Point(1, 2).div(Point(2, 1)))
    println(Point(1, 2) / Point(2, 1))
    println(Point(1, 2).rem(Point(2, 1)))
    println(Point(1, 2) % Point(2, 1))
    println(Point(1, 2).times(2))
    println(Point(1, 2) * 2)

    println(Point(1, 2).unaryPlus())
    println(+Point(1, 2))
    println(Point(1, 2).unaryMinus())
    println(-Point(1, 2))
    println(Point(1, 2).not())
    println(!Point(1, 2))
    var point = Point(1, 2)
    println(point.inc())
    println(point++)
    println(point.dec())
    println(point--)

    var list1 = listOf(1, 2, 3)
    val list2 = list1
    list1 += 4 // creates a new list under the hood because list1 is a var of immutable List
    println(list1)
    println(list2)

    val mutableList1 = mutableListOf(1, 2, 3)
    val mutableList2 = mutableList1
    mutableList1 += 4 // doesn't create a new list under the hood because mutableList1 is a mutableList
    println(mutableList1)
    println(mutableList2)
}