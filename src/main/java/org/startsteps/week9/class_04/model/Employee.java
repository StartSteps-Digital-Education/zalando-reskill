package org.startsteps.week9.class_04.model;

import java.util.Date;

// Exercise 1
public class Employee {
    private String name;
    private int id;
    private String department;
    private String jobTitle;
    private int managerId;
    private Date hireDate;
    private double salary;

    // Constructors
    public Employee(String name, int id, String department, String jobTitle, int managerId, Date hireDate, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", managerId=" + managerId +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
