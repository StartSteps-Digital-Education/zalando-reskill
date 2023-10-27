package org.startsteps.week8.class_05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseEight {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            displayGradeSummary(students);
        }
    }

    public static void displayGradeSummary(List<Student> students) {
        Map<String, Integer> gradeCountMap = new HashMap<>();
        gradeCountMap.put("A", 0);
        gradeCountMap.put("B", 0);
        gradeCountMap.put("C", 0);
        gradeCountMap.put("D", 0);
        gradeCountMap.put("F", 0);

        for (Student student : students) {
            double gpa = calculateGPA(student.getGrades());
            String grade = calculateGrade(gpa);
            gradeCountMap.put(grade, gradeCountMap.get(grade) + 1);
        }

        System.out.println("Grade Summary:");
        for (Map.Entry<String, Integer> entry : gradeCountMap.entrySet()) {
            System.out.println("Grade " + entry.getKey() + ": " + entry.getValue() + " students");
        }
    }

    public static double calculateGPA(List<String> grades) {
        // Logic to calculate GPA from grades list (assuming grades are in a format suitable for GPA calculation)
        // For example, if grades are in the format "A", "B", "C", etc., you can assign corresponding GPA values.
        // Calculate the average GPA for a student and return it.
        // For simplicity, assuming A=4, B=3, C=2, D=1, F=0.
        int totalPoints = 0;
        int totalGrades = grades.size();
        for (String grade : grades) {
            switch (grade) {
                case "A":
                    totalPoints += 4;
                    break;
                case "B":
                    totalPoints += 3;
                    break;
                case "C":
                    totalPoints += 2;
                    break;
                case "D":
                    totalPoints += 1;
                    break;
                default:
                    break;
                // F is already 0 points, so no need to handle it separately.
            }
        }
        return (double) totalPoints / totalGrades;
    }

    public static String calculateGrade(double gpa) {
        // Logic to convert GPA to letter grade (assuming standard GPA to letter grade conversion logic).
        if (gpa >= 3.5) {
            return "A";
        } else if (gpa >= 2.5) {
            return "B";
        } else if (gpa >= 1.5) {
            return "C";
        } else if (gpa >= 0.5) {
            return "D";
        } else {
            return "F";
        }
    }
}

