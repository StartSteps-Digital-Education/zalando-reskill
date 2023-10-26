package org.startsteps.week8.class_04;

import java.io.*;
import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Deserialize student from the file
        Student student = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student_data.ser"))) {
            student = (Student) in.readObject();
            System.out.println("Original Student Information:");
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (student != null) {
            // Allowing the user to update student information
            System.out.println("Enter updated GPA: ");
            double updatedGPA = scanner.nextDouble();
            student.setGpa(updatedGPA);

            System.out.println("Enter new course (or 'done' to finish adding courses): ");
            while (true) {
                String course = scanner.next();
                if (course.equalsIgnoreCase("done")) {
                    break;
                }
                student.addCourse(course);
            }

            System.out.println("Enter new hobby (or 'done' to finish adding hobbies): ");
            while (true) {
                String hobby = scanner.next();
                if (hobby.equalsIgnoreCase("done")) {
                    break;
                }
                student.addHobby(hobby);
            }

            // Serialize the updated student information
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student_data.ser"))) {
                out.writeObject(student);
                System.out.println("Student information updated and serialized successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}