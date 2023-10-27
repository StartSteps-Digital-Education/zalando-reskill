package org.startsteps.week8.class_03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseSix {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the user whose address you want to update:");
        String userName = scanner.nextLine();

        User userToUpdate = null;
        for (User user : users) {
            if (user.getName().contains(userName)) { // This doesn't work in every case. Why?
                userToUpdate = user;
                break;
            }
        }

        if (userToUpdate != null) {
            System.out.println("Enter the new address for " + userToUpdate.getName() + ":");
            String newAddress = scanner.nextLine();
            userToUpdate.setAddress(newAddress);

            // Update the CSV file with the new address
            updateCSVFile(users);

            System.out.println("Address updated successfully!");
        } else {
            System.out.println("User not found.");
        }

        displayUserData(users);
    }

    private static List<User> readUserData() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                String email = userData[2];
                String phone = userData[3];
                String address = userData[4];
                users.add(new User(name, age, email, phone, address));
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the CSV file: " + e.getMessage());
        }
        return users;
    }

    private static void updateCSVFile(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            // Write header
            writer.write("Name,Age,Email,Phone,Address");
            writer.newLine();

            // Write updated user data
            for (User user : users) {
                writer.write(user.getName() + "," + user.getAge() + "," +
                        user.getEmail() + "," + user.getPhone() + "," + user.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while updating the CSV file: " + e.getMessage());
        }
    }

    private static void displayUserData(List<User> users) {
        System.out.println("User Data from CSV:");
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Address: " + user.getAddress());
            System.out.println("----------------------");
        }
    }
}

