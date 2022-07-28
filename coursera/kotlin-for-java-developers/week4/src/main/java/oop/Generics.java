package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1d, 2d, 3d));

        System.out.println(GenericsKt.average(intList));
        System.out.println(GenericsKt.averageOfDouble(doubleList)); //the names are not overloaded when calling from java cause bytecode method signature has been changed
    }
}
