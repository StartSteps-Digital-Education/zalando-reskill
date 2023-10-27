package org.startsteps.week8.class_05;

import java.util.List;

public class ExerciseFive {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            displaySummaryReport(students);
        }
    }

    public static void displaySummaryReport(List<Student> students) {
        double totalGPA = 0;
        int studentCount = students.size();

        System.out.println("Summary Report:");
        System.out.println("List of Hobbies of Students:");

        for (Student student : students) {
            totalGPA += student.getGpa();

            System.out.println("Student: " + student.getName());
            System.out.println("Hobbies: " + student.getHobbies());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("-------------------------");
        }

        double averageGPA = totalGPA / studentCount;
        System.out.println("Average GPA of all students: " + averageGPA);
    }
}

