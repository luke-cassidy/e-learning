package nullability

fun main() {
    val s1: String = "always not null"
    val s2: String? = null // nullable
    val s3: String? = "sometimes not null" // nullable
    println("String: $s1, String?: $s2, String?: $s3")

    val s1LengthNullable: Int? = s1.length
    val s2LengthNullable: Int? = if (s2 != null) s2.length else null
    val s3LengthNullable: Int? = s3?.length // safe access operator
    println("s1Length: $s1LengthNullable, s2Length: $s2LengthNullable, s3Length: $s3LengthNullable")

    val s1LengthNotNullable: Int = s1.length
    val s2LengthNotNullable: Int = if (s2 != null) s2.length else 0
    val s3LengthNotNullable: Int = s3?.length ?: 0 // elvis operator
    println("s1Length: $s1LengthNotNullable, s2Length: $s2LengthNotNullable, s3Length: $s3LengthNotNullable")

    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2

    val i1 = (a ?: 0) + c // 2
    val i2 = (b ?: 0) + c // 3
    println("$i1$i2")

    val testString1: String? = "not null"
    if (testString1 == null) return
    println(testString1.length) // no need for safe access as the null check is done in if statement earlier in control flow

    val testString2: String? = "also not null"
    val testString2Length: Int = testString2!!.length // not null assertion operator, will throw NPE if null
    println(testString2Length)

    val testString3: String? = null
    val testString3Length: Int
    try {
        testString3Length = testString3!!.length
    } catch (npe: NullPointerException) {
        println("NullPointerException thrown")
    }
}
