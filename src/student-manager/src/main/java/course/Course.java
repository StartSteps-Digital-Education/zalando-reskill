package course;

import student.Student;

import java.io.*;
import java.util.*;
public class Course implements Serializable {
    String courseName;
    int courseID;

    public Course(String courseName, int courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }



    // CRUD operations
    public static void addCourse(List<Course> courses, Course course) {
        courses.add(course);
    }

    public static void updateCourse(List<Course> courses, int courseID, String newCourseName) {
        for (Course course : courses) {
            if (course.courseID == courseID) {
                course.courseName = newCourseName;
                // Update other details as needed
                break;
            }
        }
    }

    public static void deleteCourse(List<Course> courses, int courseID) {
        courses.removeIf(course -> course.courseID == courseID);
    }

    public static void displayCourses(List<Course> courses) {
        for (Course course : courses) {
            System.out.println("Course Name: " + course.courseName + ", ID: " + course.courseID);
            // Display other details as needed
        }
    }

    // Grading functionality
    public static void addOrUpdateGrade(Student student, int grade) {
        // Implement grading logic here
    }

    // Additional methods for sorting, searching, etc.
}

