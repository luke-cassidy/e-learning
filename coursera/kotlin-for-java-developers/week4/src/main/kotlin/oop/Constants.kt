package oop

object Test {
    const val staticIntegerField: Int = 1

    @JvmStatic
    val staticIntegerProperty: Int = 2

    @JvmField
    val staticListField: List<Int> = listOf(1,2,3)
}