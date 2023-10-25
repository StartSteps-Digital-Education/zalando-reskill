package org.startsteps.week8.class_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseNine {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();
        int totalUsers = countTotalUsers(users);
        System.out.println("Total number of users: " + totalUsers);
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

    private static int countTotalUsers(List<User> users) {
        return users.size();
    }
}

