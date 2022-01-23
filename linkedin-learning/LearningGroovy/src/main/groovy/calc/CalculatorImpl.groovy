package calc

class CalculatorImpl implements Calculator {
    @Override
    int add(int a, int b) {
        return a + b
    }

    @Override
    int subtract(int a, int b) {
        return a - b
    }

    @Override
    int multiply(int a, int b) {
        return a * b
    }

    @Override
    double divide(int a, int b) {
        try {
            return a / b
        } catch (ArithmeticException ae) {
            throw new RuntimeException("Cannot divide by zero", ae)
        }
    }
}

