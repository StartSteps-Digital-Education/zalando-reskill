package org.startsteps.week10.class_01.task01;

// Exercise 2
public class ExerciseTwo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        // Using Runnable interface
        Thread customer1 = new Thread(new Customer(account, "Customer 1 (Runnable)", 200));
        Thread customer2 = new Thread(new Customer(account, "Customer 2 (Runnable)", 300));

        // Using Thread class
        CustomerThread customer3 = new CustomerThread(account, "Customer 3 (Thread)", 400);
        CustomerThread customer4 = new CustomerThread(account, "Customer 4 (Thread)", 500);

        Thread.sleep(1000);
        customer1.start();
        Thread.sleep(1000);
        customer2.start();
        Thread.sleep(1000);
        customer3.start();
        Thread.sleep(1000);
        customer4.start();
    }
}
