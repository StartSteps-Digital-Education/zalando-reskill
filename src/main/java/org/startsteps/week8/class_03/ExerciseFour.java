package org.startsteps.week8.class_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseFour {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search term (Name, Email, or Phone):");
        String searchTerm = scanner.nextLine();

        List<User> searchResults = searchUsers(users, searchTerm);
        displaySearchResults(searchResults);
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

    private static List<User> searchUsers(List<User> users, String searchTerm) {
        List<User> searchResults = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    user.getEmail().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    user.getPhone().contains(searchTerm)) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

    private static void displaySearchResults(List<User> searchResults) {
        System.out.println("Search Results:");
        if (searchResults.isEmpty()) {
            System.out.println("No matching users found.");
        } else {
            for (User user : searchResults) {
                System.out.println("Name: " + user.getName());
                System.out.println("Age: " + user.getAge());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("Address: " + user.getAddress());
                System.out.println("----------------------");
            }
        }
    }
}