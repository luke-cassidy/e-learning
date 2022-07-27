package oop.playground;

import oop.CompanionTest;

public class Objects {
    public static void main(String[] args) {
        System.out.println(CompanionTest.foo()); // will work because it is implemented as a static method, because @JvmStatic annotation was used
//        System.out.println(CompanionTest.bar()); // will not compile as it isn't implemented as a static method
        System.out.println(CompanionTest.Companion.foo());
        System.out.println(CompanionTest.Companion.bar());
    }
}
