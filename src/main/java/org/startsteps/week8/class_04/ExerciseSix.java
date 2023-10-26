package org.startsteps.week8.class_04;

import java.io.*;
import java.util.*;

class ExerciseSix implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "123 Main St", 3.8);
        Scanner scanner = new Scanner(System.in);

        // Allowing the user to input courses and grades
        System.out.println("Enter courses and grades (Enter 'done' to finish): ");
        while (true) {
            System.out.print("Course: ");
            String course = scanner.next();
            if (course.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            student.addCourseGrade(course, grade);
        }

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
            Map<String, Double> coursesAndGrades = loadedStudent.getCoursesAndGrades();
            for (Map.Entry<String, Double> entry : coursesAndGrades.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Grade: " + entry.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
