package org.startsteps.week8.class_04;

import java.io.*;
import java.util.*;

public class ExerciseSeven implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "123 Main St", 3.8);
        student.addCourseGrade("Math", 3.8);
        student.addCourseGrade("Science", 4.0);
        student.addCourseGrade("History", 3.5);

        // Serialize the student information
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student_data.ser"))) {
            out.writeObject(student);
            System.out.println("Student information serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize and display the student information
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student_data.ser"))) {
            Student loadedStudent = (Student) in.readObject();
            System.out.println("Loaded Student Information:");
            System.out.println("Name: " + loadedStudent.getName());
            System.out.println("Age: " + loadedStudent.getAge());
            Map<String, Double> coursesAndGrades = loadedStudent.getCoursesAndGrades();
            for (Map.Entry<String, Double> entry : coursesAndGrades.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Grade: " + entry.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}