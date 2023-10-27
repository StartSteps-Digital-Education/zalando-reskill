package org.startsteps.week8.class_05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseSix {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            // Update student information
            String studentIDToUpdate = "12345"; // Student ID to update (you can take user input)
            for (Student student : students) {
                if (student.getStudentID().equals(studentIDToUpdate)) {
                    List<String> updatedCourses = new ArrayList<>();
                    List<String> updatedGrades = new ArrayList<>();

                    // Update courses and grades (you can take user input for these values)
                    updatedCourses.add("Math");
                    updatedGrades.add("A");
                    updatedCourses.add("History");
                    updatedGrades.add("B");

                    student.setCourses(updatedCourses);
                    student.setGrades(updatedGrades);
                    break;
                }
            }

            // Serialize updated student data
            serializeStudents(students, "students.ser");
            System.out.println("Student information updated and serialized.");
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
}