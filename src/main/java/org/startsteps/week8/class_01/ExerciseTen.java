package org.startsteps.week8.class_01;

import java.util.*;

public class ExerciseTen {


    static Map<Integer, String> colors = new HashMap<>();

    public static void printColors(){

        colors.put(1, "red");
        colors.put(2, "blue");
        colors.put(3, "green");
        colors.put(4, "teal");


        for (int i = 0; i < colors.size(); i++) {
            System.out.println((i+1)+ ". " + colors.get(i));
            //1. red
            //2. blue
            //3. green
        }

        Scanner scanner = new Scanner(System.in);
        int colorNr = scanner.nextInt();

    }

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

        // Get the current year to calculate birth year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = currentYear - age;

        System.out.print("Enter your gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your favorite color: ");
        String favoriteColor = scanner.nextLine();

        // Display summary report
        System.out.println("\nSummary Report:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Birth Year: " + birthYear);
        System.out.println("Gender: " + gender);
        System.out.println("Favorite Color: " + favoriteColor);

        // Closing the scanner
        scanner.close();
    }
}
