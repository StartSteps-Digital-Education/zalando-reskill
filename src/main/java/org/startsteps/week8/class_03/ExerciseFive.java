package org.startsteps.week8.class_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExerciseFive {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting option: ");
        System.out.println("1. Sort by Age");
        System.out.println("2. Sort by Name");
        int option = scanner.nextInt();

        if (option == 1) {
            sortByAge(users);
        } else if (option == 2) {
            sortByName(users);
        } else {
            System.out.println("Invalid option selected.");
            return;
        }

        displaySortedUsers(users);
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

    private static void sortByAge(List<User> users) {
        Collections.sort(users, (user1, user2) -> Integer.compare(user1.getAge(), user2.getAge()));
    }

    private static void sortByName(List<User> users) {
        Collections.sort(users, (user1, user2) -> user1.getName().compareTo(user2.getName()));
    }

    private static void displaySortedUsers(List<User> users) {
        System.out.println("Sorted User Data:");
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