package org.startsteps.week8.class_03;

import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class ExerciseOne {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St, Cityville"));
        users.add(new User("Alice Smith", 25, "alice.smith@example.com", "987-654-3210", "456 Elm St, Townsville"));

        String csvFile = "users.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Writing CSV header
            writer.append("Name,Age,Email,Phone,Address\n");

            // Writing user data to CSV
            for (User user : users) {
                writer.append(user.getName())
                        .append(",")
                        .append(String.valueOf(user.getAge()))
                        .append(",")
                        .append(user.getEmail())
                        .append(",")
                        .append(user.getPhone())
                        .append(",")
                        .append(user.getAddress())
                        .append("\n");
            }
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the CSV file: " + e.getMessage());
        }
    }
}

