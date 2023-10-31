package org.startsteps.week9.class_02;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating an employee with all details
        Date hireDate = new Date(); // Replace this with the actual hire date
        Employee employee1 = new Employee("John Doe", 1, "IT", "Developer", 0, hireDate, 60000.0);

        // Creating an employee and setting details separately
        Employee employee2 = new Employee("Jane Smith", 2, "HR", "Manager", 1, null, 0);
        Date newHireDate = new Date(); // Set the hire date separately
        employee2.setHireDate(newHireDate);
        employee2.setSalary(65000.0);

        // Printing employee details
        System.out.println(employee1);
        System.out.println(employee2);

        OrganizationHierarchy orgHierarchy = new OrganizationHierarchy();

        // Adding employees to the organization hierarchy
        orgHierarchy.addEmployee(new Employee("CEO", 1, "Executive", "CEO", 0, new Date(), 100000.0));
        orgHierarchy.addEmployee(new Employee("Manager A", 2, "IT", "Manager", 1, new Date(), 80000.0));
        orgHierarchy.addEmployee(new Employee("Manager B", 3, "HR", "Manager", 1, new Date(), 75000.0));
        orgHierarchy.addEmployee(new Employee("Employee X", 4, "IT", "Developer", 2, new Date(), 60000.0));
        orgHierarchy.addEmployee(new Employee("Employee Y", 5, "HR", "HR Assistant", 3, new Date(), 50000.0));


        // Printing the organization hierarchy (in-order traversal)
        System.out.println("Organization Hierarchy:");
        orgHierarchy.printHierarchy(orgHierarchy.getRoot());

        // Displaying the organization hierarchy with proper indentation
        System.out.println("Organization Hierarchy with proper indentation:");
        orgHierarchy.displayHierarchy(orgHierarchy.getRoot(), 0);

        // Get and display employees reporting to Manager A (employee with ID 2)
        int managerId = 2;
        List<Employee> subordinates = orgHierarchy.getEmployeesReportingToManager(managerId);
        System.out.println("Employees reporting to Manager A:");
        for (Employee employee : subordinates) {
            System.out.println(employee.getName());
        }
    }
}

