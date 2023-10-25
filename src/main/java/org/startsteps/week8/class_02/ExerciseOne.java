package org.startsteps.week8.class_02;
import java.io.*;

// Extend your program to read and display the user's phone number and address from the file using FileInputStream.
// Add error handling for file input in case the file does not exist or is empty.

public class ExerciseOne {
    public static void main(String[] args) {
        try {
            File file = new File("userInfo.txt");

            if (!file.exists()) {
                // If the file doesn't exist, create it
                file.createNewFile();
                System.out.println("userInfo.txt file created.");
            }

            FileInputStream fileInput = new FileInputStream("userInfo.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String phoneNumber = bufferedReader.readLine();
            String address = bufferedReader.readLine();

            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Address: " + address);

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

