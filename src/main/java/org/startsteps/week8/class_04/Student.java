package org.startsteps.week8.class_04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String address;
    private double gpa;
    private List<String> coursesTaken;
    private List<String> hobbies;

    private Map<String, Double> coursesAndGrades;


    public Student(String name, int age, String address, double gpa) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
        this.coursesTaken = new ArrayList<>();
        this.hobbies = new ArrayList<>();
        this.coursesAndGrades = new HashMap<>();
    }

    public void addCourse(String course) {
        coursesTaken.add(course);
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(List<String> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Double> getCoursesAndGrades() {
        return coursesAndGrades;
    }

    public void setCoursesAndGrades(Map<String, Double> coursesAndGrades) {
        this.coursesAndGrades = coursesAndGrades;
    }

    public void addCourseGrade(String course, double grade) {
        coursesAndGrades.put(course, grade);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + address + ", GPA: " + gpa +
                ", Courses Taken: " + coursesTaken + ", Hobbies: " + hobbies;
    }

    public void serialize(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    public static Student deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) in.readObject();
        }
    }
}