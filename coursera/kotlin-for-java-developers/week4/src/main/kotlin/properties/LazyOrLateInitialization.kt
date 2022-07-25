package properties

fun main() {
    println("---before lazyValue access---")
    // lazyValue not accessed
    println("---after lazyValue access---")
    println(lazyValue)

    val kotlinActivity = KotlinActivity()
    try {
        // exception throw as lateinit property not assigned at this point
        kotlinActivity.onCreate(Bundle())
    } catch (e: UninitializedPropertyAccessException) {
        println("Caught UninitializedProperty Exception: ${e.message}")
    }

    kotlinActivity.init()
    // no exception thrown as lateinit property now assigned
    kotlinActivity.onCreate(Bundle())
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class MyData {
    val foo = "foo"
}

class Bundle

open class Activity {
    open fun onCreate(savedInstanceState: Bundle?) {
        println("Activity onCreate($savedInstanceState)")
    }
}

class KotlinActivity : Activity() {
    lateinit var myData: MyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Is initialized? ${this::myData.isInitialized}")
        println(myData.foo)
    }

    fun init() {
        myData = MyData()
    }
}


