package org.startsteps.week8.class_02;

import java.io.*;

public class ExerciseEight {
    public static void main(String[] args) {
        try {
            // Read total interactions from log file
            FileInputStream fileInput = new FileInputStream("log.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int totalInteractions = 0;
            while (bufferedReader.readLine() != null) {
                totalInteractions++;
            }

            System.out.println("Total Interactions: " + totalInteractions);
        } catch (FileNotFoundException e) {
            System.err.println("Log file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}

