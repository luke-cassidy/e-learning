class Basics {
    static void main(String[] args) {
        def hello = "Hello World!"
        println hello

        int age = 40
        println age
        println age.getClass()

        def name = "Luke"
        println name
        println name.getClass()

        Person lukeCassidy = new Person()
        lukeCassidy.setFirstName("Luke")
        lukeCassidy.setLastName("Cassidy")
        lukeCassidy.setAge(29)

        println lukeCassidy.getFullName()
        println lukeCassidy.getAge()

        if (lukeCassidy.isMiddleAged()) {
            println lukeCassidy.getFullName() + " is middle aged"
        } else {
            println lukeCassidy.getFullName() + " is " + lukeCassidy.getAge() + " years old"
        }

        def persons = [lukeCassidy, new Person(firstName: "John", lastName: "Doe", age: 40)]
        for (Person person : persons) {
            println person.getFullName()
        }

        def johnDoe = new Person(firstName: "Johnny", lastName: "Doe", age: 50)

        try {
            johnDoe.getFirstName().toLong()
        } catch (Exception e) {
            assert e instanceof NumberFormatException
            println "Cannot convert a String to Long"
        }

        println johnDoe.getFirstName()
        println johnDoe.getFirstName().dropRight(2)
    }
}
