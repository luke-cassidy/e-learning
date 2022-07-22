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