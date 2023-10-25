package org.startsteps.week8.class_02;

import java.io.*;

public class ExerciseNine {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.csv"));
            String line = reader.readLine();
            String[] numbers = line.split(",");

            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }

            double average = (double) sum / numbers.length;

            System.out.println("Sum of numbers: " + sum);
            System.out.println("Average of numbers: " + average);

            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

