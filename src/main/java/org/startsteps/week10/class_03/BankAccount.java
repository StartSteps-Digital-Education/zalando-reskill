package org.startsteps.week10.class_03;

class BankAccount {
    private int accountNumber;
    private int balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public BankAccount(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Account " + accountNumber + " deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount for Account " + accountNumber);
        }
    }

    public synchronized void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Account " + accountNumber + " withdrawn $" + amount + ". New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount for Account " + accountNumber);
        } else {
            System.out.println("Insufficient funds for withdrawal from Account " + accountNumber);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}
