package org.startsteps.week9.class_01;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {

    private Map<Integer, Employee> employeeMap;

    // Constructor to initialize the HashMap
    public EmployeeManagementSystem() {
        employeeMap = new HashMap<>();
    }

    public EmployeeManagementSystem(Map<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    // Create operation: Add an employee to the HashMap
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    // Read operation: Get an employee by ID from the HashMap
    public Employee getEmployeeById(int id) {
        // Check access
        return employeeMap.get(id);
    }

    // Update operation: Update an employee in the HashMap
    public boolean updateEmployee(int id, Employee updatedEmployee) {
        if (employeeMap.containsKey(id)) {
            employeeMap.put(id, updatedEmployee);
            return true;
        } else {
            System.out.println("Employee with ID " + id + " not found.");
            return false;
        }
    }

    // Delete operation: Remove an employee from the HashMap by ID
    public void deleteEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Main method to demonstrate CRUD operations
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        // Create a HashSet to store unique employees
        HashSet<Employee> employeeHashSet = new HashSet<>();

        // Adding employees
        Employee employee1 = new Employee("John Doe", 1, "IT", "Developer", 0);
        Employee employee2 = new Employee("Jane Smith", 2, "HR", "Manager", 1);
        Employee employee3 = new Employee("Alice Johnson", 3, "Finance", "Analyst", 2);

        system.addEmployee(employee1);
        system.addEmployee(employee2);
        system.addEmployee(employee3);

        // Adding a duplicate employee (same ID and other attributes)
        Employee duplicateEmployee = new Employee("John Doe", 1, "IT", "Developer", 0);
        employeeHashSet.add(duplicateEmployee); // This won't be added as it's a duplicate

        // Printing unique employees from the HashSet
        System.out.println("Unique Employees:");
        for (Employee employee : employeeHashSet) {
            System.out.println(employee);
        }

        // Updating an employee
        Employee updatedEmployee = new Employee("Updated Name", 1, "Updated Department", "Updated Job", 0);
        system.updateEmployee(1, updatedEmployee);

        // Getting and printing an employee
        Employee retrievedEmployee = system.getEmployeeById(1);
        if (retrievedEmployee != null) {
            System.out.println("Retrieved Employee: " + retrievedEmployee);
        }

        // Deleting an employee
        system.deleteEmployee(2);

        // Printing all employees in the system
        System.out.println("Employees in the system:");
        for (Employee employee : system.employeeMap.values()) {
            System.out.println(employee);
        }
    }


    // Exercise 4 with Map


    // Add an employee to the system
    public void addEmployeeMap(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    // Remove an employee from the system by ID
    public void removeEmployeeById(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            System.out.println("Employee with ID " + id + " has been removed.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // Main method to demonstrate employee management operations
    public static void main2(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // Adding employees
        Employee employee1 = new Employee("John Doe", 1, "IT", "Developer", 0);
        Employee employee2 = new Employee("Jane Smith", 2, "HR", "Manager", 1);
        system.addEmployeeMap(employee1);
        system.addEmployeeMap(employee2);

        // Searching for an employee
        int searchId = 1;
        Employee searchedEmployee = system.searchEmployeeById(searchId);
        if (searchedEmployee != null) {
            System.out.println("Employee found: " + searchedEmployee);
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        // Removing an employee
        int removeId = 2;
        system.removeEmployeeById(removeId);

        // Searching for the same employee after removal
        searchedEmployee = system.searchEmployeeById(removeId);
        if (searchedEmployee != null) {
            System.out.println("Employee found: " + searchedEmployee);
        } else {
            System.out.println("Employee with ID " + removeId + " not found.");
        }
    }


    // Exercise 5 with filters

    // Filter employees by department and return a list
    public List<Employee> filterByDepartment(String department) {
        return employeeMap.values()
                .stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }

    // Filter employees by job title and return a list
    public List<Employee> filterByJobTitle(String jobTitle) {
        return employeeMap.values()
                .stream()
                .filter(employee -> employee.getJobTitle().equalsIgnoreCase(jobTitle))
                .toList();
    }

    // Filter employees by manager ID and return a list
    public List<Employee> filterByManager(int managerId) {
        return employeeMap.values()
                .stream()
                .filter(employee -> employee.getManagerId() == managerId)
                .toList();
    }

    // Main method to demonstrate filtering employees
    public static void main3(String[] args) {
        // Create employee objects and add them to the map
        Map<Integer, Employee> employeeMap = Map.of(
                1, new Employee("John Doe", 1, "IT", "Developer", 0),
                2, new Employee("Jane Smith", 2, "HR", "Manager", 1),
                3, new Employee("Alice Johnson", 3, "IT", "QA Engineer", 1),
                4, new Employee("Bob Brown", 4, "Finance", "Analyst", 2)
        );

        EmployeeManagementSystem system = new EmployeeManagementSystem(employeeMap);

        // Filter employees by department and print the result
        String department = "IT";
        List<Employee> employeesInIT = system.filterByDepartment(department);
        System.out.println("Employees in " + department + " department:");
        employeesInIT.forEach(System.out::println);

        // Filter employees by job title and print the result
        String jobTitle = "Manager";
        List<Employee> managers = system.filterByJobTitle(jobTitle);
        System.out.println("\nManagers:");
        managers.forEach(System.out::println);

        // Filter employees by manager ID and print the result
        int managerId = 1;
        List<Employee> employeesManagedByManager = system.filterByManager(managerId);
        System.out.println("\nEmployees managed by Employee ID " + managerId + ":");
        employeesManagedByManager.forEach(System.out::println);

        system.createReport();
    }

    public int getTotalEmployees() {
        return employeeMap.size();
    }

    // Method to get employees per department
    public Map<String, Integer> getEmployeesPerDepartment() {
        Map<String, Integer> departmentCount = new HashMap<>();
        for (Employee employee : employeeMap.values()) {
            String department = employee.getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }
        return departmentCount;
    }

    public void createReport(){
        // Get and print total number of employees
        int totalEmployees = getTotalEmployees();
        System.out.println("Total Employees: " + totalEmployees);

        // Get and print employees per department
        Map<String, Integer> employeesPerDepartment = getEmployeesPerDepartment();
        System.out.println("Employees per Department:");
        for (Map.Entry<String, Integer> entry : employeesPerDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}