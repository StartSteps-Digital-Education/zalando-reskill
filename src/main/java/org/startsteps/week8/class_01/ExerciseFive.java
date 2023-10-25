package day1;

import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class ExerciseFive {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userinfo.txt"))) {
            String line;
            System.out.println("day1.User Information:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
