package day1;

import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int age = 0;
        boolean isValidAge = false;
        while (!isValidAge) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());

                if (age > 0) {
                    isValidAge = true;
                } else {
                    System.out.println("Age must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Age must be a positive integer. Please try again.");
            }
        }

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        // Collect favorite book information
        System.out.print("Enter your favorite book title: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        int publicationYear = 0;
        boolean isValidYear = false;
        while (!isValidYear) {
            try {
                System.out.print("Enter the publication year of the book: ");
                publicationYear = Integer.parseInt(scanner.nextLine());

                if (publicationYear > 0) {
                    isValidYear = true;
                } else {
                    System.out.println("Publication year must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Publication year must be a positive integer. Please try again.");
            }
        }

        // Display all the collected information
        System.out.println("\nday1.User Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Favorite Book: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);

        // Writing user information to a text file
        try (FileWriter writer = new FileWriter("userinfo.txt")) {
            writer.write("day1.User Information:\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Favorite Book: " + bookTitle + "\n");
            writer.write("Author: " + author + "\n");
            writer.write("Publication Year: " + publicationYear + "\n");
            System.out.println("day1.User information has been written to userinfo.txt file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            // Closing the scanner
            scanner.close();
        }
    }
}
