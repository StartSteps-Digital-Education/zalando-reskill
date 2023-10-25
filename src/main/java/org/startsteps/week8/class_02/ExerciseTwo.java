package org.startsteps.week8.class_02;

import java.io.*;
import java.util.Scanner;

// Allow the user to update their email, phone number, and address in the program,
// write it to the file, and display the updated information.

public class ExerciseTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileInputStream fileInput = new FileInputStream("userInfo.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String phoneNumber = bufferedReader.readLine();
            String address = bufferedReader.readLine();

            System.out.println("Current Phone Number: " + phoneNumber);
            System.out.println("Current Address: " + address);

            // Update user data
            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            System.out.print("Enter new address: ");
            String newAddress = scanner.nextLine();

            FileWriter fileWriter = new FileWriter("userInfo.txt");
            fileWriter.write(newPhoneNumber + "\n" + newAddress);
            fileWriter.close();

            System.out.println("User information updated successfully.");

            // Display updated information
            System.out.println("Updated Phone Number: " + newPhoneNumber);
            System.out.println("Updated Address: " + newAddress);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
        }
    }
}
