package org.startsteps.week3.class_05;

public class BankApplication {

    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingAccount(1000.0);
        BankAccount checkingAccount = new CheckingAccount(500.0);

        // Perform operations on both account types
        savingsAccount.deposit(200.0);
        checkingAccount.deposit(300.0);

        savingsAccount.withdraw(50.0);
        checkingAccount.withdraw(75.0);

        // Calculate and display the final balances
        double savingsBalance = savingsAccount.getBalance();
        double checkingBalance = checkingAccount.getBalance();

        System.out.println("Savings Account Balance: $" + savingsBalance);
        System.out.println("Checking Account Balance: $" + checkingBalance);
    }
}
