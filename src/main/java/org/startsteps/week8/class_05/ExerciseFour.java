package org.startsteps.week8.class_05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ExerciseFour {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            Util.searchStudent(students, "Alice"); // Example search by name
            Util.searchStudent(students, "12345"); // Example search by student ID
            Util.searchStudent(students, "Reading"); // Example search by hobby

            // Example: Delete a student's record
            String studentIDToDelete = "12345"; // Student ID to delete (you can take user input)
            boolean deleted = deleteStudent(students, studentIDToDelete);
            if (deleted) {
                System.out.println("Student with ID " + studentIDToDelete + " has been deleted.");
                serializeStudents(students, "students.ser"); // Serialize updated list back to the file
            } else {
                System.out.println("Student with ID " + studentIDToDelete + " not found.");
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
}

