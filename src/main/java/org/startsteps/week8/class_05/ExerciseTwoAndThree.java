package org.startsteps.week8.class_05;

import java.util.List;

public class ExerciseTwoAndThree {
    public static void main(String[] args) {
        // Serialize student objects and save them to a file (similar to the previous example)
        Util.prefillStudents();

        // Deserialize student objects from the file (similar to the previous example)
        List<Student> students = Util.deserializeStudents("students.ser");

        // Search function
        Util.searchStudent(students, "Alice"); // Example search by name
        Util.searchStudent(students, "12345"); // Example search by student ID
        Util.searchStudent(students, "Reading"); // Example search by hobby
    }
}

