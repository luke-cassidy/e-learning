class Beyond {
    static void main(String[] args) {
        Person lukeCassidy = new Person("Luke", "Cassidy", 29)
        Person johnDoe = new Person("John", "Doe", 40)
        Person maryHill = new Person("Mary", "Hill", 50)

        Closure johnDoeToString = {
            println johnDoe.toString()
        }
        johnDoeToString()

        Closure personToString = {
            Person person -> println person.toString()
        }
        personToString(lukeCassidy)

        handlePerson(personToString, lukeCassidy)

        Closure personToFullName = {
            Person person -> println person.getFullName()
        }
        handlePerson(personToFullName, lukeCassidy)

        def allPersons = [lukeCassidy, johnDoe, maryHill]
        assert allPersons instanceof List
        assert allPersons.size() == 3
        assert allPersons[2] == maryHill

        allPersons.each { println it }

        allPersons.eachWithIndex { Person person, int index -> println index + ": " + person }

        assert allPersons.find { it.getLastName() == "Hill" } == maryHill
        assert allPersons.collect { it.getAge() <= 40 } == [true, true, false]
        assert allPersons.sort { it.getAge() } == [lukeCassidy, johnDoe, maryHill]
        assert allPersons.sort { Person p1, Person p2 -> p2.getAge() - p1.getAge() } == [maryHill, johnDoe, lukeCassidy]

        File inFile = new File("src/main/resources/john-doe.txt")
        println inFile.getText('UTF-8')

        Closure fileToPerson = { File personFile ->
            Person person = new Person()
            personFile.eachLine { String line, Integer no ->
                if (no == 1) {
                    person.setFirstName(line)
                } else if (no == 2) {
                    person.setLastName(line)
                } else if (no == 3) {
                    person.setAge(line.toInteger())
                } else {
                    throw new RuntimeException("A person test file should only have 3 lines")
                }
            }
            person
        }
        println fileToPerson(inFile)

        File outFile = new File("src/main/resources/mary-hill.txt")
        outFile.with {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(it)))
            writer.writeLine "Mary"
            writer.writeLine "Hill"
            writer.writeLine "30"
            writer.flush()
            writer.close()
        }
        // more concise version
        outFile.withWriter {
            it.writeLine "Mary"
            it.writeLine "Hill"
            it.writeLine "30"
        }

        outFile.append "1"
        outFile << "2"

        Person djingoDjango = new Person().with {
            setFirstName("Djingo")
            setLastName("Django")
            setAge(150)
            it
        }
        println djingoDjango

        File binFile = new File("src/main/resources/djingo-django.bin")
        binFile.withOutputStream {
            new ObjectOutputStream(it).writeObject(djingoDjango)
        }
        // more concise version
        binFile.withObjectOutputStream {
            it.writeObject(djingoDjango)
        }

        binFile.withObjectInputStream {
            println it.readObject()
        }
    }

    static void handlePerson(Closure closure, Person person) {
        if (person == null) {
            throw new RuntimeException("person cannot be null")
        }
        closure(person)
    }

}
