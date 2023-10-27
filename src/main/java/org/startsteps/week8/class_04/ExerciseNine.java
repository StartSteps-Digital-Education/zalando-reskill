package org.startsteps.week8.class_04;

import java.io.*;
import java.util.*;

public class ExerciseNine implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        // Serialize student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, "123 Main St", 3.8));
        students.add(new Student("Bob", 22, "456 Elm St", 3.5));
        students.add(new Student("Charlie", 21, "789 Oak St", 3.9));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students_data.ser"))) {
            out.writeObject(students);
            System.out.println("Student objects serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred during serialization: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Deserialize and display student information
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students_data.ser"))) {
            Object obj = in.readObject();
            if (obj instanceof List) {
                List<?> loadedStudents = (List<?>) obj;
                System.out.println("List of Serialized Students:");
                for (Object student : loadedStudents) {
                    if (student instanceof Student) {
                        Student loadedStudent = (Student) student;
                        System.out.println("Name: " + loadedStudent.getName() + ", GPA: " + loadedStudent.getGpa());
                    } else {
                        System.err.println("Invalid object found during deserialization.");
                    }
                }
            } else {
                System.err.println("Invalid data structure found in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}