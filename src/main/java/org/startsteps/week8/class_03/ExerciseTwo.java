package org.startsteps.week8.class_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExerciseTwo {
    public static void main(String[] args) {
        String csvFile = "users.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Read the header line first
            line = reader.readLine();
            System.out.println("User Data from CSV:");
            System.out.println(line); // Display header

            // Read and display user data from CSV
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                String email = userData[2];
                String phone = userData[3];
                String address = userData[4];

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the CSV file: " + e.getMessage());
        }
    }
}