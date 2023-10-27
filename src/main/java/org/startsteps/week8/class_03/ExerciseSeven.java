package org.startsteps.week8.class_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciseSeven {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name or email of the user you want to remove:");
        String searchTerm = scanner.nextLine();

        boolean removed = removeUser(users, searchTerm);
        if (removed) {
            System.out.println("User data removed successfully!");
            updateCSVFile(users);
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

    private static boolean removeUser(List<User> users, String searchTerm) {
        Iterator<User> iterator = users.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equalsIgnoreCase(searchTerm) || user.getEmail().equalsIgnoreCase(searchTerm)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
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