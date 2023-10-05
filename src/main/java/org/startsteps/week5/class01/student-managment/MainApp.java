import java.util.List;

// jar cvmf Manifest.txt StudentManagementSystem.jar *.class

public class MainApp {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();

        studentManager.addStudent(new Student("Alice", 101, 86.2));
        studentManager.addStudent(new Student("Bob", 102, 82.2));
        studentManager.addStudent(new Student("Charley", 103, 90.2));

        studentManager.deleteStudent(102);

        List<Student> allStudents = studentManager.getAllStudents();
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }
}
