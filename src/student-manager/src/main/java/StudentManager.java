import course.Course;
import student.Student;
import user.User;
import user.UserRole;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static List<User> users = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        readDataFromFile(); // Load existing data from file

        while (true) {
            System.out.println("Welcome to Student Manager!");
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    if (loginUser()) {
                        // Continue with other functionalities based on user role
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                case 3:
                    saveDataToFile(); // Save data to file before exiting
                    System.out.println("Exiting Student Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Select role:\n1. Admin\n2. Teacher\n3. Student");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        UserRole role;
        switch (roleChoice) {
            case 1:
                role = UserRole.ADMIN;
                break;
            case 2:
                role = UserRole.TEACHER;
                break;
            case 3:
                role = UserRole.STUDENT;
                break;
            default:
                System.out.println("Invalid role. Defaulting to Student role.");
                role = UserRole.STUDENT;
        }

        User newUser = new User(username, password, role);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    private static boolean loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful! Welcome, " + user.role + " " + user.username + ".");
                return true;
            }
        }

        return false;
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("data.txt")))) {
            oos.writeObject(users);
            oos.writeObject(students);
            oos.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace(); // proper logging
        }
    }

    private static void readDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("data.txt")))) {
            users = (List<User>) ois.readObject();
            students = (List<Student>) ois.readObject();
            courses = (List<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions (file not found on the first run, for example)
        }
    }
}
