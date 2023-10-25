package org.startsteps.week8.class_02;

import java.io.*;
import java.util.Scanner;

// Implement the ability to delete a user's information from the file if requested by the user.

public class ExerciseThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File("userInfo.txt");
            if (file.exists()) {
                // Read user data
                FileInputStream fileInput = new FileInputStream("userInfo.txt");
                InputStreamReader reader = new InputStreamReader(fileInput);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String phoneNumber = bufferedReader.readLine();
                String address = bufferedReader.readLine();

                bufferedReader.close();

                // Display user data
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Address: " + address);

                // Confirmation step
                System.out.print("Do you want to delete your information? (yes/no): ");
                String confirmation = scanner.nextLine().toLowerCase();

                if (confirmation.equals("yes")) {
                    file.delete();
                    System.out.println("User information deleted successfully.");
                } else {
                    System.out.println("User information not deleted.");
                }
            } else {
                System.out.println("File not found. Unable to delete user information.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

