package org.startsteps.week8.class_05;

import java.util.List;

public class ExerciseSeven {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            String courseToSearch = "Math"; // Course to search for (you can take user input)
            listStudentsByCourse(students, courseToSearch);
        }
    }

    public static void listStudentsByCourse(List<Student> students, String courseToSearch) {
        System.out.println("Students who have taken the course '" + courseToSearch + "':");
        boolean found = false;
        for (Student student : students) {
            List<String> courses = student.getCourses();
            List<String> grades = student.getGrades();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).equals(courseToSearch)) {
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Student ID: " + student.getStudentID());
                    System.out.println("Grade: " + grades.get(i));
                    System.out.println("-------------------------");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No students found for the course '" + courseToSearch + "'.");
        }
    }
}

