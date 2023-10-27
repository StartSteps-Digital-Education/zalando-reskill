package org.startsteps.week8.class_05;

import java.io.*;

public class ExerciseOne {
    public static void main(String[] args) {
        // Serialization
        Util.prefillStudents();

        // Deserialization
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.ser"))) {
            Student student1 = (Student) inputStream.readObject();
            Student student2 = (Student) inputStream.readObject();

            System.out.println("Deserialization complete.");
            System.out.println("Student 1: Name - " + student1.getName() + ", Age - " + student1.getAge() + ", Hobbies - " + student1.getHobbies());
            System.out.println("Student 2: Name - " + student2.getName() + ", Age - " + student2.getAge() + ", Hobbies - " + student2.getHobbies());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}