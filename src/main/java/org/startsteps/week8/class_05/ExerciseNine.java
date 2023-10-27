package org.startsteps.week8.class_05;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            // Delete student information
            String studentIDToDelete = "12345"; // Student ID to delete (you can take user input)
            boolean confirmation = getUserConfirmation("Are you sure you want to delete the student with ID " + studentIDToDelete + "? (yes/no): ");

            if (confirmation) {
                boolean deleted = deleteStudent(students, studentIDToDelete);
                if (deleted) {
                    serializeStudents(students, "students.ser"); // Serialize updated list back to the file
                    System.out.println("Student with ID " + studentIDToDelete + " has been deleted.");
                } else {
                    System.out.println("Student with ID " + studentIDToDelete + " not found.");
                }
            } else {
                System.out.println("Deletion canceled by user.");
            }
        }
    }

    public static void serializeStudents(List<Student> students, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Student student : students) {
                outputStream.writeObject(student);
            }
            System.out.println("Serialization complete.");
        } catch (IOException e) {
            System.out.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    public static boolean deleteStudent(List<Student> students, String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public static boolean getUserConfirmation(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String userInput = scanner.nextLine().trim().toLowerCase();
        return userInput.equals("yes");
    }
}