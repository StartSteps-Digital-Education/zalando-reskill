package org.startsteps.week3.class_05;

public interface BankAccount {
    void deposit(double amount);

    void withdraw(double amount, double transactionFee);
    void withdraw(double amount);
    double getBalance();

}
