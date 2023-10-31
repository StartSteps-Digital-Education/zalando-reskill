package org.startsteps.week8.class_05;

import java.io.*;
import java.util.List;

public class ExerciseTen {
    public static void main(String[] args) {
        List<Student> students = Util.deserializeStudents("students.ser");

        if (students != null) {
            // Generate summary report
            for(Student student : students) {
                double averageGPA = calculateAverageGPA(student.getGrades());
                int totalStudents = students.size();
                // You can calculate other relevant statistics if needed.

                // Export summary report to a text file
                exportSummaryReport(averageGPA, totalStudents, "summary_report.txt");
                System.out.println("Summary report exported to 'summary_report.txt'.");
            }
        }
    }

    public static double calculateAverageGPA(List<String> grades) {
        int totalPoints = 0;
            int totalGrades = grades.size();

            for (String grade : grades) {
                // Convert grades to points and sum them up
                // For example: A=4, B=3, C=2, D=1, E=0, F=0
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
                    // E, F is already 0 points, so no need to handle it separately.
                }
            }

            if (totalGrades > 0) {
                return (double) totalPoints / totalGrades; // (double) 15/2 = 7.5
            } else {
                return 0.0; // Return 0 if no grades are available to calculate the GPA.
            }
        }

    public static void exportSummaryReport(double averageGPA, int totalStudents, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            // Write summary report to the text file
            writer.println("Summary Report");
            writer.println("Average GPA: " + averageGPA);
            writer.println("Total Number of Students: " + totalStudents);
            // Write other relevant statistics to the file if available

            System.out.println("Summary report exported to 'summary_report.txt'.");
        } catch (IOException e) {
            System.out.println("Error occurred while exporting summary report: " + e.getMessage());
        }
    }
}
