package org.startsteps.week10.class_04.solid.task1;


// Subtask 1.1
public class AccountDetails {
    private int accountNumber;
    private int balance;

    public AccountDetails(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public synchronized void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

