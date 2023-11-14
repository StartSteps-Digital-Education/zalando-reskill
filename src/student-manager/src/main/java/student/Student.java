package student;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    String name;
    int studentID;

    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    // CRUD operations
    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void updateStudent(List<Student> students, int studentID, String newName) {
        for (Student student : students) {
            if (student.studentID == studentID) {
                student.name = newName;
                // Update other details as needed
                break;
            }
        }
    }

    public static void deleteStudent(List<Student> students, int studentID) {
        students.removeIf(student -> student.studentID == studentID);
    }

    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", ID: " + student.studentID);
            // Display other details as needed
        }
    }

    // Additional methods for sorting, searching, etc.
}
