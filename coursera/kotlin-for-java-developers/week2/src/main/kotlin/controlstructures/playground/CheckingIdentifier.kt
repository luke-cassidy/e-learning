package controlstructures.playground

//initial solution
fun isValidIdentifierInitial(s: String): Boolean {
    if (s.isEmpty()) return false
    else if (s[0].toLowerCase() in 'a'..'z' || s[0] == '_') {
        for (char: Char in s) {
            when (char.toLowerCase()) {
                in 'a'..'z' -> continue
                in '0'..'9' -> continue
                '_' -> continue
                else -> return false
            }
        }
    } else {
        return false
    }
    return true
}

//concise solution
fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(char: Char): Boolean = char == '_' || char.toLowerCase() in 'a'..'z' || char in '0'..'9'

    if (s.isEmpty() || s[0].toLowerCase() !in 'a'..'z' && s[0] != '_') return false

    for (c: Char in s.substring(1 until s.length)) {
        if (!isValidCharacter(c)) return false
    }

    return true
}

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}