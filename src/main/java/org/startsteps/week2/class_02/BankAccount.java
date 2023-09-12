package org.startsteps.week2.class_02;

//
//Create a new Java class called "BankAccount".
//        Add private instance variables of type int called "accountNumber".
//        Add private instance variables of type String called "accountHolderName".
//        Add private instance variables of type double called "balance" and "interestRate".
//        Add a public constructor that takes in the account number, account holder name, balance, and interest rate as
//        parameters and initializes the instance variables.
//        Add public methods called "deposit" and "withdraw" that take in a double parameter and update the balance
//        accordingly.
//        Add a public method called "calculateInterest" that calculates the interest earned on the balance using the interest
//        rate and returns the result.
//        Add public getter methods for the account number, account holder name, balance, and interest rate.
//        Add a public static variable called "count" that keeps track of the number of BankAccount objects created.
//        Add a public static method called "getCount" that returns the value of the "count" variable.
//        Test your class by creating multiple instances of it and calling the methods.

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance; // cents

    private double interestRate;
    private static int count = 0;


    public BankAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.interestRate = interestRate;
        count++;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    // getter


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static int getCount() {
        return count;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1283838, "John Doe", 1000.0, 0.05);
        BankAccount account2 = new BankAccount(1283831, "Justina Wina", 4000.0, 0.03);
        account1.deposit(50.0);
        account2.withdraw(1000.0);
        System.out.println("Account number" + account1.getAccountNumber());
        System.out.println("Balance" + account1.getBalance());
        System.out.println("Balance" + account2.getBalance());
        System.out.println("Interest rate" + account1.getInterestRate());
        System.out.println("Interest rate" + account1.calculateInterest());
        System.out.println("Number of accounts" + getCount());

    }

}
