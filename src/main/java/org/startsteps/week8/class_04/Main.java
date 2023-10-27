package org.startsteps.week8.class_04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "students_data.ser";

    public static void main(String[] args) {
        List<Map<String, Object>> students = new ArrayList<>();

        // Sample data
        students.add(createStudent("Alice", 3.8, Arrays.asList("Math", "Science"), Arrays.asList("Reading", "Sports")));
        students.add(createStudent("Bob", 3.5, Arrays.asList("History", "English"), Arrays.asList("Music", "Gaming")));
        students.add(createStudent("Charlie", 3.9, Arrays.asList("Physics", "Chemistry"), Arrays.asList("Traveling", "Cooking")));

        // Serialize student data with error handling
        serializeStudents(students, FILE_NAME);

        // Deserialize and display student information with error handling
        List<Map<String, Object>> loadedStudents = deserializeStudents(FILE_NAME);
        if (loadedStudents != null) {
            displayStudents(loadedStudents);

            // Update student information
            updateStudent(loadedStudents, "Alice", 4.0, Arrays.asList("Biology", "History"), Arrays.asList("Music", "Reading"));
            serializeStudents(loadedStudents, FILE_NAME);

            // Display updated student information
            System.out.println("\nUpdated Student Information:");
            displayStudents(deserializeStudents(FILE_NAME));

            // Backup serialized data
            backupSerializedData(FILE_NAME, "backup_students_data.ser");

            // Calculate and display average GPA
            calculateAndDisplayAverageGPA(loadedStudents);
        } else {
            System.out.println("Error occurred during deserialization.");
        }
    }

    private static Map<String, Object> createStudent(String name, double gpa, List<String> courses, List<String> hobbies) {
        Map<String, Object> student = new HashMap<>();
        student.put("Name", name);
        student.put("GPA", gpa);
        student.put("Courses", courses);
        student.put("Hobbies", hobbies);
        return student;
    }

    private static void serializeStudents(List<Map<String, Object>> students, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
            System.out.println("Student data serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    private static List<Map<String, Object>> deserializeStudents(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = in.readObject();
            if (obj instanceof List) {
                return (List<Map<String, Object>>) obj;
            } else {
                System.err.println("Invalid data structure found in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during deserialization: " + e.getMessage());
        }
        return null;
    }

    private static void displayStudents(List<Map<String, Object>> students) {
        System.out.println("Serialized Student Information:");
        for (Map<String, Object> student : students) {
            System.out.println("Name: " + student.get("Name") +
                    ", GPA: " + student.get("GPA") +
                    ", Courses: " + student.get("Courses") +
                    ", Hobbies: " + student.get("Hobbies"));
        }
    }

    private static void updateStudent(List<Map<String, Object>> students, String name, double gpa, List<String> courses, List<String> hobbies) {
        for (Map<String, Object> student : students) {
            String studentName = (String) student.get("Name");
            if (studentName.equals(name)) {
                student.put("GPA", gpa);
                student.put("Courses", courses);
                student.put("Hobbies", hobbies);
                System.out.println("Student " + name + " updated successfully.");
                return;
            }
        }
        System.out.println("Student with name " + name + " not found.");
    }

    private static void backupSerializedData(String sourceFile, String backupFile) {
        try {
            Files.copy(new File(sourceFile).toPath(), new File(backupFile).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup created successfully for disaster recovery purposes.");
        } catch (IOException e) {
            System.err.println("Error occurred during backup: " + e.getMessage());
        }
    }

    private static void calculateAndDisplayAverageGPA(List<Map<String, Object>> students) {
        double totalGPA = 0;
        int studentCount = students.size();
        for (Map<String, Object> student : students) {
            totalGPA += (double) student.get("GPA");
        }
        double averageGPA = studentCount > 0 ? totalGPA / studentCount : 0;
        System.out.println("Average GPA of all students: " + averageGPA);
    }
}