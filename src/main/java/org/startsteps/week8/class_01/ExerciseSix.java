package org.startsteps.week8.class_01;

import java.util.Calendar;
import java.util.Scanner;

public class ExerciseSix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);


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

        // Calculate the birth year
        int birthYear = currentYear - age;

        // Display the birth year
        System.out.println("day1.User's Birth Year: " + birthYear);
    }
}

