package org.startsteps.week8.class_03;

import java.io.*;
import java.util.*;

public class ExerciseTen {
    private static final String CSV_FILE = "user_report.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();
        generateCSVReport(users);
        System.out.println("CSV report generated successfully.");
    }

    private static List<User> readUserData() {
        // For demonstration purposes, using sample data
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "alice@example.com", "1234567890", "123 Main St"));
        users.add(new User("Bob", 35, "bob@example.com", "9876543210", "456 Elm St"));
        // Add more users as needed
        return users;
    }

    private static void generateCSVReport(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            writer.write("Name,Age,Email,Phone,Address");
            writer.newLine();

            for (User user : users) {
                writer.write(user.getName() + "," + user.getAge() + "," +
                        user.getEmail() + "," + user.getPhone() + "," + user.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while generating the CSV report: " + e.getMessage());
        }
    }
}