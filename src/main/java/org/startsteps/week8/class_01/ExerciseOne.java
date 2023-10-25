package org.startsteps.week8.class_01;

import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User menil = new User();

        System.out.print("Enter your name: ");
        menil.name = scanner.nextLine();

        System.out.print("Enter your age: ");
        menil.age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter your email address: ");
        menil.email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        menil.phoneNumber = scanner.nextLine();

        // Displaying the collected information
        menil.printUserDetails();

        // Closing the scanner
        scanner.close();
    }
}
