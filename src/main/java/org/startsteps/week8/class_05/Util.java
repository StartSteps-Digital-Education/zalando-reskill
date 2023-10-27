package org.startsteps.week8.class_05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void prefillStudents(){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            Student student1 = new Student("Alice", 20, List.of("Reading", "Traveling"), "12345");
            Student student2 = new Student("Bob", 22, List.of("Gaming", "Cooking"), "12345");

            outputStream.writeObject(student1);
            outputStream.writeObject(student2);
            System.out.println("Serialization complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> deserializeStudents(String fileName) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Student student = (Student) inputStream.readObject();
                    students.add(student);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
            System.out.println("Deserialization complete.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization: " + e.getMessage());
            return null;
        }
        return students;
    }

    public static void searchStudent(List<Student> students, String searchTerm) {
        System.out.println("Searching for: " + searchTerm);
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equals(searchTerm) || student.getStudentID().equals(searchTerm) || student.getHobbies().contains(searchTerm)) {
                System.out.println("Student found:");
                System.out.println("Name: " + student.getName());
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Hobbies: " + student.getHobbies());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
