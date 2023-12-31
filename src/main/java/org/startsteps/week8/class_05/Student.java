package org.startsteps.week8.class_05;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private String name;
    private int age;
    private String studentID;
    private List<String> hobbies;
    private double gpa;
    private List<String> courses;
    private List<String> grades;


    public Student(String name, int age, List<String> hobbies, String studentID) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.studentID = studentID;
        this.grades = new ArrayList<>(){{
            add("A");
            add("B");
            add("C");
            add("D");
        }};
    }

    public Student(String name, int age, List<String> hobbies, String studentID, double gpa) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.studentID = studentID;
        this.gpa = gpa;
        this.grades = new ArrayList<>(){{
            add("A");
            add("B");
            add("C");
            add("D");
        }};
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }
}