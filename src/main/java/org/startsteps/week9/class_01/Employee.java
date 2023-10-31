package org.startsteps.week9.class_01;

import java.util.Objects;

public class Employee {
    private String name;
    private int id;
    private String department;
    private String jobTitle;
    private int managerId;

    // Constructor

    public Employee() {
    }

    // Constructor
    public Employee(String name, int id, String department, String jobTitle, int managerId) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter and Setter methods for jobTitle
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // Getter and Setter methods for managerId
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    // Override toString() method to display employee information
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", managerId=" + managerId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, department, jobTitle, managerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                managerId == employee.managerId;
    }
}