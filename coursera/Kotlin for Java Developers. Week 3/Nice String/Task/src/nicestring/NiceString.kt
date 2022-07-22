package nicestring

fun String.isNice(): Boolean {
    val subStrings: Set<String> = setOf("bu", "ba", "be")
    val containsSubString = subStrings.any { this.contains(it) }

    val vowels: Set<Char> = setOf('a', 'e', 'i', 'o', 'u')
    val containsVowels = this.count { it in vowels } >= 3

    val letters = 'a'..'z'
    val containsDoubleLetter = this.zipWithNext { a, b -> a in letters && a == b }.contains(true)

    return listOf(!containsSubString, containsVowels, containsDoubleLetter).count { it } >= 2
}

// more concise and efficient version
fun String.isNiceConcise(): Boolean {
    val containsSubString = setOf("bu", "ba", "be").any { this.contains(it) }

    val containsVowels = this.count { it in setOf('a', 'e', 'i', 'o', 'u') } >= 3

    val letters = 'a'..'z'
    // this will break when predicate it first matched, meaning less iteration
    val containsDoubleLetter = (0 until this.lastIndex).any { this[it] in letters && this[it] == this[it + 1] }

    return listOf(!containsSubString, containsVowels, containsDoubleLetter).count { it } >= 2
}