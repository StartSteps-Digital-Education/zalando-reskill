package org.startsteps.week8.class_01;

import java.util.Scanner;

public class ExerciseTwoAndThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int age = 0;
        boolean isValidAge = false;
        while (!isValidAge) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());

                if (age > 0) {
                    isValidAge = true;
                } else {
                    System.out.println("Age must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Age must be a positive integer. Please try again.");
            }
        }

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        // Displaying the collected information
        System.out.println("\nday1.User Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);

        // Closing the scanner
        scanner.close();
    }

    public void displayInformation(String name, int age, String email, String phoneNumber){
        // Displaying the collected information
        System.out.println("\nday1.User Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}