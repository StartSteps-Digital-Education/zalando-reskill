package org.startsteps.week8.class_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciseEight {
    private static final String CSV_FILE = "users.csv";

    public static void main(String[] args) {
        List<User> users = readUserData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new user");
            System.out.println("2. Search for a user");
            System.out.println("3. Update user address");
            System.out.println("4. Delete a user");
            System.out.println("5. Display all users");
            System.out.println("6. Save user data to CSV file");
            System.out.println("7. Count and display total number of users");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addUser(users, scanner);
                    break;
                case 2:
                    searchUser(users, scanner);
                    break;
                case 3:
                    updateUserAddress(users, scanner);
                    break;
                case 4:
                    deleteUser(users, scanner);
                    break;
                case 5:
                    displayUserData(users);
                    break;
                case 6:
                    saveUserData(users);
                    break;
                case 7:
                    int totalUsers = countTotalUsers(users);
                    System.out.println("Total number of users: " + totalUsers);
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
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

    private static void addUser(List<User> users, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after nextInt
        System.out.println("Enter user details (Name,Age,Email,Phone,Address):");
        String userData = scanner.nextLine();
        String[] userDataArray = userData.split(",");
        if (userDataArray.length == 5) {
            String name = userDataArray[0].trim();
            int age = Integer.parseInt(userDataArray[1].trim());
            String email = userDataArray[2].trim();
            String phone = userDataArray[3].trim();
            String address = userDataArray[4].trim();
            users.add(new User(name, age, email, phone, address));
            System.out.println("User added successfully!");
        } else {
            System.out.println("Invalid input format. User not added.");
        }
    }

    private static void searchUser(List<User> users, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after nextInt
        System.out.println("Enter the name or email of the user you want to search:");
        String searchTerm = scanner.nextLine().trim().toLowerCase();

        List<User> searchResults = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchTerm) || user.getEmail().toLowerCase().contains(searchTerm)) {
                searchResults.add(user);
            }
        }

        if (!searchResults.isEmpty()) {
            System.out.println("Search Results:");
            for (User user : searchResults) {
                System.out.println("Name: " + user.getName());
                System.out.println("Age: " + user.getAge());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("Address: " + user.getAddress());
                System.out.println("----------------------");
            }
        } else {
            System.out.println("No matching users found.");
        }
    }

    private static void updateUserAddress(List<User> users, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after nextInt
        System.out.println("Enter the name or email of the user whose address you want to update:");
        String searchTerm = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchTerm) || user.getEmail().toLowerCase().contains(searchTerm)) {
                System.out.println("Enter the new address for " + user.getName() + ":");
                String newAddress = scanner.nextLine();
                user.setAddress(newAddress);
                found = true;
                System.out.println("Address updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    private static void deleteUser(List<User> users, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after nextInt
        System.out.println("Enter the name or email of the user you want to delete:");
        String searchTerm = scanner.nextLine().trim().toLowerCase();

        Iterator<User> iterator = users.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().toLowerCase().contains(searchTerm) || user.getEmail().toLowerCase().contains(searchTerm)) {
                iterator.remove();
                found = true;
                System.out.println("User data deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    private static void displayUserData(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users to display.");
        } else {
            System.out.println("User Data:");
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

    private static void saveUserData(List<User> users) {
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

            System.out.println("User data saved to CSV file successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the CSV file: " + e.getMessage());
        }
    }

    private static int countTotalUsers(List<User> users) {
        return users.size();
    }
}