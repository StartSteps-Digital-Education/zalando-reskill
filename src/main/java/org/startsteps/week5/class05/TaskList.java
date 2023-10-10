package org.startsteps.week5.class05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskList {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            int taskNumber = 1;
            for (Task task : tasks) {
                System.out.println(taskNumber + ". " + task);
                taskNumber++;
            }
        }
    }

    public void editTask(int taskNumber, Scanner scanner) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task taskToEdit = tasks.get(taskNumber - 1);
            System.out.print("Enter new Task Title: ");
            String newTitle = scanner.nextLine();
            taskToEdit.setTitle(newTitle);
            System.out.print("Enter new Task Description: ");
            String newDescription = scanner.nextLine();
            taskToEdit.setDescription(newDescription);
            System.out.print("Enter new Task Priority (High, Medium, Low): ");
            String newPriority = scanner.nextLine();
            taskToEdit.setPriority(newPriority);
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
