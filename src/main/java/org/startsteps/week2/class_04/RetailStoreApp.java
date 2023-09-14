package org.startsteps.week2.class_04;

import java.util.Scanner;

public class RetailStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of products in the inventory: ");
        int maxCapacity = scanner.nextInt();

        scanner.nextLine();

        InventoryManager manager = new InventoryManager(maxCapacity);

        boolean exit = false;

        while (!exit) {
            System.out.println("Retail Store Inventory Management");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add product logic
                    break;
                case 2:
                    // Update product logic
                    break;
                case 3:
                    // View inventory logic
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

