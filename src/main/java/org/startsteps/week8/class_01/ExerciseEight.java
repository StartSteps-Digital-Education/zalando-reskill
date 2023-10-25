package day1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExerciseEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        // Validate the email address
        if (isValidEmail(email)) {
            System.out.println("Email address is valid.");
        } else {
            System.out.println("Invalid email address format. Please enter a valid email address.");
        }

        // Close the scanner
        scanner.close();
    }

    // Function to validate email address format
    private static boolean isValidEmail(String email) {
        // Basic email format validation (contains "@" and ".")
        return email.contains("@") && email.contains(".");
    }

    // I tried, sorry it didn't work. Me </3 Regex
    private static boolean isValidEmailBetter(String email){
        Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
}
