package org.startsteps.week8.class_04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseThree {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, "123 Main St", 3.8));
        students.add(new Student("Bob", 22, "456 Elm St", 3.5));
        students.add(new Student("Charlie", 21, "789 Oak St", 3.9));

        String fileName = "students_data.ser";

        // Serialize multiple instances of Student class to the same file with error handling
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
            System.out.println("Students serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize students from the file with error handling for class/version mismatches
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = in.readObject();
            if (obj instanceof List) {
                List<?> loadedStudents = (List<?>) obj;
                System.out.println("Loaded Students:");
                for (Object student : loadedStudents) {
                    if (student instanceof Student) {
                        System.out.println(student);
                    } else {
                        System.out.println("Invalid object found in the file.");
                    }
                }
            } else {
                System.out.println("Invalid data structure found in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
