package org.startsteps.week8.class_03;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseThree {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        displayUserData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a new user entry (Name,Age,Email,Phone,Address):");
        String newUserInput = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            writer.newLine(); // Start a new line for the new user entry
            writer.write(newUserInput);
            System.out.println("New user entry added successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while adding the new user entry: " + e.getMessage());
        }

        displayUserData();
    }

    private static void displayUserData() {
        System.out.println("User Data from CSV:");
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the CSV file: " + e.getMessage());
        }
    }
}

