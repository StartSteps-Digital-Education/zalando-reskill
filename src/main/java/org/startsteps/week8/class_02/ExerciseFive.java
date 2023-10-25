package org.startsteps.week8.class_02;

import java.io.*;

// Implement a feature that allows the user to specify the name of the file where their data will be stored and read from.

public class ExerciseFive {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter file name to read/write data: ");
            String fileName = reader.readLine();

            FileInputStream fileInput = new FileInputStream(fileName);
            // Read or write data from the file as needed

            System.out.println("Operation completed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
