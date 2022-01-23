package com.linkedinlearning.reverser;

public class Main2 {
    public static void main(String[] args) {
        CommonsStringReverser stringReverser = new CommonsStringReverser();
        System.out.println("Reverse of abc: " + stringReverser.reverse("abc"));
        System.out.println("Reverse of automobile: " + stringReverser.reverse("automobile"));
    }
}
