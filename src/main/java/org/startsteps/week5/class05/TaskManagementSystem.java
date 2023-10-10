package org.startsteps.week5.class05;

import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();
                    Task task = new Task(title, description, priority);
                    taskList.addTask(task);
                    break;

                case 2:
                    taskList.viewTasks();
                    break;

                case 3:
                    taskList.viewTasks();
                    System.out.print("Enter the task number to edit: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    taskList.editTask(taskNumber, scanner);
                    break;

                case 4:
                    taskList.viewTasks();
                    System.out.print("Enter the task number to delete: ");
                    int taskToDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    taskList.deleteTask(taskToDelete);
                    break;

                case 5:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

