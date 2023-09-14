package org.startsteps.week2.class_03;

import java.util.Scanner;

public class Teritary {
    public static void main(String[] args) {
        // if (a || b)
        // return (a || b) && (c && d)

        // 12 if > 5 ? 19 : 30;
//        if ( i > 5) {
//            return 19;
//        } else {
//            return 30;
//        }
//        int a = 6;
//        int num = a > 5 ? 19 : 30;
//
//        Prompt the user to enter an integer.
//                Use a do-while loop to read integers from the user until the user enters a negative integer.
//        Inside the loop, add the positive integers to a running total.
//                After the loop, print the sum of the positive integers entered by the user.

//        int num;
//        int sum = 0;
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.println("Enter an integer : ");
//            num = sc.nextInt(); // - 2
//
//            if (num >= 0) {
//                sum += num; // 1, 2,
//            }
//        } while (num >= 0);
//
//        System.out.println("The sum of positive integers is: " + sum);
        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;
        int choice;
        int result = 0;

        System.out.println("Enter first number: ");
        num1 = sc.nextInt();

        System.out.println("Enter second number: ");
        num2 = sc.nextInt();

        System.out.println("Choose an operation to perform ");
        System.out.println("1. addition ");
        System.out.println("2. subtraction ");
        System.out.println("3. multiplication ");
        System.out.println("4. division ");
        choice = sc.nextInt();

        switch (choice) {
            case 1 -> result = num1 + num2;
            case 2 -> result = num2 - num1;
            case 3 -> result = num1 * num2;
            case 4 -> {
                if (num2 == 0) {
                    System.out.println("Error: division by 0");
                } else {
                    result = num1 / num2;
                }
            }
            // 0  -> 8 0 // exception -
            default -> System.out.println("Invalid choice");
        }

        System.out.println(result);

    }
}
