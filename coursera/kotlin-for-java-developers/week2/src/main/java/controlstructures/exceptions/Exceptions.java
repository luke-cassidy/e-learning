package controlstructures.exceptions;

import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) {
        try {
            ExceptionsKt.foo();
        } catch (Exception e) {
            System.out.println("foo(), Exception: " + e);
        }
        try {
            ExceptionsKt.bar();
        } catch (IOException e) {
            System.out.println("bar(), Exception: " + e);
        }
    }
}
