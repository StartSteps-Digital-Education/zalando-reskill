package org.startsteps.week1.class_03;

public class FunctionsTryItAnswers {

    //    Exercise 1: Create a Function
//    Create a function named sayHello that prints "Hello, World!".
//    Call this function in the main method.
    public static void sayHello() {
        System.out.println("Hello, World!");
    }

    //    Exercise 2: Function with Parameters
//    Create a function named add that takes two integers as parameters and returns their sum.
//  	Call this function in the main method and print the result.
    public static int add(int a, int b) {
        return a + b;
    }


    //    Exercise 3: Print Your Name
//  	Write a function that takes a String (your name) and prints "Hello, [Your Name]!"
    public static void printName(String name) {
        System.out.println("Hello, " + name + "!");
    }


    //    Exercise 4: Is Zero
//  	Write a function that takes an integer and prints "Zero" if the integer is zero, otherwise it prints "Not Zero."
    public static void isZero(int number) {
        if (number == 0) {
            System.out.println("Zero");
        } else {
            System.out.println("Not Zero");
        }
    }


    //    Exercise 5: Double Up
//  	Write a function that takes a number, doubles it, and then prints it.
    public static void doubleUp(int number) {
        System.out.println(number * 2);
    }


    public static void main(String[] args) {
        sayHello();

        System.out.println("Sum: " + add(3, 5));

        printName("Nadin");

        isZero(6);

        doubleUp(5);
    }
}
