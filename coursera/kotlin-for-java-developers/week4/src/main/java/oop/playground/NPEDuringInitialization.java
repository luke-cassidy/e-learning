package oop.playground;

public class NPEDuringInitialization {

    static class A {
        private final String value;

        public A(String value) {
            this.value = value;
            getValue().length();
        }

        public String getValue() {
            return value;
        }
    }

    static class B extends A {
        private final String value;

        public B(String value) {
            super(value);
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        new B("a");
    }
}
