package org.startsteps.week10.class_01.task01;

// Exercise 1
public class ExerciseOne {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        BankAccount account = new BankAccount(1000);

        Thread customer1 = new Thread(new Customer(account, "Customer 1", 200));
        Thread customer2 = new Thread(new Customer(account, "Customer 2", 300));

        Thread.sleep(1000);
        customer1.start();
        System.out.println(customer1);

        Thread.sleep(1000);
        customer2.start();
        System.out.println(customer2);
    }
}
