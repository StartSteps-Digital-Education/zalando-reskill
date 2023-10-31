package org.startsteps.week9.class_02;

import java.util.ArrayList;
import java.util.List;

// OrganizationHierarchy class representing the binary tree structure
public class OrganizationHierarchy {
    private TreeNode root; // Root node of the binary tree

    // Method to add an employee to the organization hierarchy
    // Exercise 2
    public void addEmployee(Employee employee) {
        if (root == null) {
            root = new TreeNode(employee);
        } else {
            insertEmployee(root, employee);
        }
    }

    // Method to add an employee to the organization hierarchy and establish parent-child relationship
    // Exercise 2
    public void addEmployee2(Employee employee) {
        TreeNode newNode = new TreeNode(employee);
        if (root == null) {
            root = newNode; // If the tree is empty, the new node becomes the root
        } else {
            insertEmployee2(root, newNode);
        }
    }

    // Recursive method to insert an employee into the binary tree
    // Exercise 3
    private void insertEmployee(TreeNode node, Employee employee) {
        if (employee.getId() < node.getEmployee().getId()) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(employee));
            } else {
                insertEmployee(node.getLeft(), employee);
            }
        } else if (employee.getId() > node.getEmployee().getId()) {
            if (node.getRight() == null) {
                node.setRight(new TreeNode(employee));
            } else {
                insertEmployee(node.getRight(), employee);
            }
        }
    }

    // Recursive method to insert an employee into the binary tree and establish parent-child relationship
    // Exercise 3
    private void insertEmployee2(TreeNode node, TreeNode newNode) {
        if (newNode.getEmployee().getManagerId() < node.getEmployee().getId()) {
            if (node.getLeft() == null) {
                node.setLeft(newNode); // If the left child is empty, the new node becomes the left child
            } else {
                insertEmployee2(node.getLeft(), newNode); // Recur on the left subtree
            }
        } else if (newNode.getEmployee().getManagerId() > node.getEmployee().getId()) {
            if (node.getRight() == null) {
                node.setRight(newNode); // If the right child is empty, the new node becomes the right child
            } else {
                insertEmployee2(node.getRight(), newNode); // Recur on the right subtree
            }
        }
        // Note: If managerId is equal to the node's ID, you can decide how to handle it (e.g., skip or handle it accordingly)
    }


    // Method to print the organization hierarchy (in-order traversal)
    // Exercise 2
    public void printHierarchy(TreeNode node) {
        if (node == null) {
            return;
        }
        printHierarchy(node.getLeft());
        System.out.println(node.getEmployee());
        printHierarchy(node.getRight());
    }


    public TreeNode getRoot() {
        return root;
    }

    // Method to find the lowest common manager of two employees
    // Exercise 4
    public Employee findLowestCommonManager(int employeeId1, int employeeId2) {
        return findLowestCommonManager(root, employeeId1, employeeId2);
    }

    // Recursive method to find the lowest common manager of two employees
    // Exercise 4
    private Employee findLowestCommonManager(TreeNode node, int employeeId1, int employeeId2) {
        if (node == null) {
            return null;
        }

        // If either employeeId1 or employeeId2 is found, return the current node's employee
        if (node.getEmployee().getId() == employeeId1 || node.getEmployee().getId() == employeeId2) {
            return node.getEmployee();
        }

        // Recur on the left and right subtrees to find both employees
        Employee leftResult = findLowestCommonManager(node.getLeft(), employeeId1, employeeId2);
        Employee rightResult = findLowestCommonManager(node.getRight(), employeeId1, employeeId2);

        // If both employees are found in different subtrees, the current node's employee is the lowest common manager
        if (leftResult != null && rightResult != null) {
            return node.getEmployee();
        }

        // If only one employee is found, return that employee; otherwise, return null
        return leftResult != null ? leftResult : rightResult;
    }

    // Method to display the organization hierarchy with proper indentation
    // Exercise 5
    public void displayHierarchy(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // Recur on the right subtree with increased depth
        displayHierarchy(node.getRight(), depth + 1);

        // Indent based on depth and display the current employee's information
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }
        System.out.println(indentation + node.getEmployee().getName());

        // Recur on the left subtree with increased depth
        displayHierarchy(node.getLeft(), depth + 1);
    }

    // Method to get employees reporting to a specific manager
    // Exercise 6
    public List<Employee> getEmployeesReportingToManager(int managerId) {
        List<Employee> employees = new ArrayList<>();
        TreeNode managerNode = findEmployeeNode(root, managerId);
        if (managerNode != null) {
            collectSubordinates(managerNode.getLeft(), employees);
            collectSubordinates(managerNode.getRight(), employees);
        }
        return employees;
    }

    // Recursive method to collect employees reporting to a manager
    // Exercise 6
    private void collectSubordinates(TreeNode node, List<Employee> employees) {
        if (node == null) {
            return;
        }

        // Add the current employee to the list
        employees.add(node.getEmployee());

        // Recur on left and right subtrees to collect subordinates
        collectSubordinates(node.getLeft(), employees);
        collectSubordinates(node.getRight(), employees);
    }

    // Helper method to find the node of an employee with a specific ID
    // Exercise 6
    private TreeNode findEmployeeNode(TreeNode node, int employeeId) {
        if (node == null) {
            return null;
        }

        // If the current node is the employee we are looking for, return the node
        if (node.getEmployee().getId() == employeeId) {
            return node;
        }

        // Recur on left and right subtrees to find the employee
        TreeNode leftResult = findEmployeeNode(node.getLeft(), employeeId);
        TreeNode rightResult = findEmployeeNode(node.getRight(), employeeId);

        // If the employee is found in either subtree, return the corresponding node
        return leftResult != null ? leftResult : rightResult;
    }

}