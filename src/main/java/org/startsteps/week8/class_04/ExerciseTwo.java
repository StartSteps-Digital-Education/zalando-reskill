package org.startsteps.week8.class_04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseTwo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, "123 Main St", 3.8));
        students.add(new Student("Bob", 22, "456 Elm St", 3.5));
        students.add(new Student("Charlie", 21, "789 Oak St", 3.9));

        String fileName = "students_data.ser";

        // Serialize multiple instances of Student class to the same file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
            System.out.println("Students serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize students from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Student> loadedStudents = (List<Student>) in.readObject();
            System.out.println("Loaded Students:");
            for (Student student : loadedStudents) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
