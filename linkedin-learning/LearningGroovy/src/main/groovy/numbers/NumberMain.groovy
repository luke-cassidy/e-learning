package numbers;

class NumberMain {
    static void main(String[] args) {
        File dir = new File("src/main/resources/numbers")

        List<Number> numbers = []
        dir.eachFileRecurse {
            if (it.isFile()) {
                it.eachLine {
                    if (it.isNumber()) {
                        if (it.isLong()) {
                            numbers.add(it.toLong())
                        } else if (it.isDouble()) {
                            numbers.add(it.toDouble())
                        } else {
                            throw new NumberFormatException("Cannot convert line to Long or Double")
                        }
                    }
                    it
                }
            }
        }

        println numbers
        numbers.sort()
        println numbers
        println numbers.max()
        println numbers.sum()

        numbers << 2
        println numbers

        Map map1 = [:]
        println map1

        Map<String, Integer> map2 = ["aString1": 1, "aString2": 2]
        println map2
    }
}
