package org.example.class_3;

public class ControlFlowAnswers {
    public static void main(String[] args) {
        //Declare an integer variable and initialize it to any value.
        //Use an if statement to check if the value is greater than 10.
        // If it is, print "The value is greater than 10."
        int value = 15;
        if (value > 10) {
            System.out.println("The value is greater than 10");
        }


        //Declare an integer variable and initialize it to any value.
        //Use an if-else statement to check if the value is even or odd. Print the result
        int secondValue = 15;
        if (secondValue % 2 == 0) {
            System.out.println("The value is even");
        } else {
            System.out.println("The value is odd");
        }


        //Use a for loop to print numbers from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }


        //Use a while loop to print "Hello, World!" five times.
        int counter = 0;
        while (counter < 5) {
            System.out.println("Hello, World!");
            counter++;
        }

    }
}
