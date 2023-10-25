package org.startsteps.week8.class_02;
import java.io.*;

// Extend your program to read and display the user's favorite color from the file.
public class ExerciseSix {
    public static void main(String[] args) {
        try {
            FileInputStream fileInput = new FileInputStream("favColor.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String favoriteColor = bufferedReader.readLine();

            System.out.println("Favorite Color: " + favoriteColor);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

