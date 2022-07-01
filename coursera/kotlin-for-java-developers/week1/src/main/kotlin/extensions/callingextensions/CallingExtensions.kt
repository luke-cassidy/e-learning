package extensions.callingextensions

open class Parent {
    open fun memberFoo() = "member parent"
    open fun foo(string: String) = "member parent: $string"
}

class Child : Parent() {
    override fun memberFoo() = "member child"
    override fun foo(string: String) = "member child: $string"
}

fun Parent.foo() = "extension parent"
fun Child.foo() = "extension child"

// extension functions shadowed
@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
fun Parent.foo(string: String) = "extension parent: $string"

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
fun Child.foo(string: String) = "extension child: $string"

// need to change jvm name to avoid bytecode clash with extension functions
@JvmName("fooJvm")
fun foo(parent: Parent): String = "static parent"

@JvmName("fooJvm")
fun foo(child: Child): String = "static child"

fun main() {
    val parent: Parent = Child()
    println(parent.foo())
    println(parent.memberFoo())
    println(parent.foo("test"))
    println(foo(parent))
}