package org.startsteps.week8.class_02;

import java.io.*;
import java.util.Scanner;

// Create a function that calculates and displays the user's age category (e.g., child, teenager, adult, senior) based on their age.
public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Read user age from the file
            FileInputStream fileInput = new FileInputStream("userInfo.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int age = Integer.parseInt(bufferedReader.readLine());

            System.out.println("User Age: " + age);

            // Confirmation step
            System.out.print("Do you want to update your age? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                System.out.print("Enter new age: ");
                int newAge = Integer.parseInt(scanner.nextLine());

                FileWriter fileWriter = new FileWriter("userInfo.txt");
                fileWriter.write(String.valueOf(newAge));
                fileWriter.close();

                System.out.println("Age updated successfully.");
            }

            // Calculate and display age category
            String ageCategory = calculateAgeCategory(age);
            System.out.println("Age Category: " + ageCategory);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
        }
    }

    private static String calculateAgeCategory(int age) {
        if (age < 13) {
            return "Child";
        } else if (age < 20) {
            return "Teenager";
        } else if (age < 65) {
            return "Adult";
        } else {
            return "Senior";
        }
    }
}
