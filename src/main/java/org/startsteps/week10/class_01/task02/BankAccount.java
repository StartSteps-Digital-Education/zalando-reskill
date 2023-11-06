package org.startsteps.week10.class_01.task02;

// Exercise 1
class BankAccount {

    private int balance;
    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Different solution:
    /*
    public void deposit(int amount) {
        synchronized (this) {
            if (amount > 0) {
                balance += amount;
                System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrawn $" + amount + ". New balance: $" + balance);
            } else if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }
     */

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized int getBalance() {
        return balance;
    }
}