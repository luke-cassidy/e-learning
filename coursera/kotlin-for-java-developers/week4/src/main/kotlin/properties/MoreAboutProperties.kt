package properties

interface User {
    val nickname: String
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookNickname(accountId)
    private fun getFacebookNickname(accountId: Int): String = "$accountId"
}

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

interface Session {
    val user: User
}

fun analyseUserSession(session: Session) {
    // have to use a local variable as session.user might return different users of different types on each access,
    // depending on how the overridden "open" variable or custom "get" method is implemented
    val user = session.user
    if (user is FacebookUser) {
        println(user.accountId)
    }
}

val String.medianChar
    get(): Char? {
        println("Calculating...")
        return getOrNull(length / 2)
    }

var StringBuilder.lastChar: Char
    get() = this[length - 1]
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    val facebookSession = object : Session {
        override val user: User = FacebookUser(1234)
    }
    println("facebook nickname: ${facebookSession.user.nickname}")
    analyseUserSession(facebookSession)

    val subscribingSession = object : Session {
        override val user: User = SubscribingUser("Luke")
    }
    println("subscribing nickname: ${subscribingSession.user.nickname}")
    analyseUserSession(subscribingSession)

    val s = "abc"
    println(s.medianChar)
    println(s.medianChar)

    val sb = java.lang.StringBuilder("Kotlin?")
    println(sb)
    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb.lastChar)
    println(sb)
}