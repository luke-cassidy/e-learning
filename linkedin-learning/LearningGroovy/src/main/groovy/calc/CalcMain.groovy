package calc

class CalcMain {
    static void main(String[] args) {
        Calculator calculator = new CalculatorImpl()

        assert calculator.add(1, 2) == 3
        assert calculator.subtract(1, 2) == -1
        assert calculator.multiply(1, 2) == 2
        assert calculator.divide(1, 2) == 0.5d
        assert calculator.divide(2, 1) == 2
        assert calculator.divide(2, -4) == -0.5d
        assert calculator.divide(0, 2) == 0
        try {
            calculator.divide(2, 0)
        } catch (Exception e) {
            assert e instanceof RuntimeException
            assert e.getMessage() == "Cannot divide by zero"
        }
    }
}
