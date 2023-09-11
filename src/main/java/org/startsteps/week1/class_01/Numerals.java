package org.startsteps.week1.class_01;


import java.util.Scanner;

public class Numerals {
    public static void main(String[] args) {
        // accept an input -> process -> output
        // num1, num 2 -> 3 + 4 -> 7

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.println("3. Quit");

        System.out.print("Enter your choice (1-3)");
        // data types
        // String, integer, boolean (t/false), float, double, long...
        int choice = scanner.nextInt();
        scanner.nextLine();

        // condition =>
        if (choice == 1) {
            System.out.println("Enter binary number: ");
            String binaryStr = scanner.nextLine();

            // string is a 0, 1 (0001)
            if (isValidBinary(binaryStr)) {
                int decimalValue = Integer.parseInt(binaryStr, 2);
                System.out.println("Decimal value is: " + decimalValue);
            } else {
                System.out.println("Invalid binary number. Please add a valid one");
            }
        } else if (choice == 2) {
            System.out.println("Enter a decimal number: ");
            int decimalValue = scanner.nextInt();
            scanner.nextLine();

            if (decimalValue >= 0) {
                String binaryResult = Integer.toBinaryString(decimalValue);
                System.out.println("Binary value: " + binaryResult);
            } else {
                System.out.println("Invalid decimal number. Please add a valid one");
            }
        } else if (choice == 3) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice. Please choose a valid option (1-3)");
        }

        scanner.close();


    }

    private static boolean isValidBinary(String binaryStr) {
        return binaryStr.matches("[01]+");
    }
}
