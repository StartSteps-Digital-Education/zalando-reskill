package org.startsteps.week8.class_04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ExerciseOne {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Alice", 20, "123 Main St", 3.8);
        student.addCourse("Math");
        student.addCourse("Physics");
        student.addHobby("Reading");
        student.addHobby("Chess");

        // Serializing the object to a file
        student.serialize("student_data.ser");

//        FileOutputStream fos = new FileOutputStream("student.out");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(student);
//        oos.flush();
//        oos.close();


        // Deserializing the object from the file
        Student loadedStudent = Student.deserialize("student_data.ser");
        System.out.println(loadedStudent);
    }
}

