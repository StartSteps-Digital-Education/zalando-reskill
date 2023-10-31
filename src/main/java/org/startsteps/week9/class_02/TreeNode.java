package org.startsteps.week9.class_02;

// TreeNode class representing nodes in the binary tree
// Exercise 2
class TreeNode {
    private Employee employee;
    private TreeNode left; // Left child
    private TreeNode right; // Right child

    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "employee=" + employee +
                '}';
    }
}
