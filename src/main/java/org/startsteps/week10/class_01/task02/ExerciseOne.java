package org.startsteps.week10.class_01.task02;

public class ExerciseOne {
        public static void main(String[] args) throws InterruptedException {
            BankAccount account = new BankAccount(1000);

            // Deposit and withdraw operations
            account.deposit(500);
            Thread.sleep(1000);
            account.withdraw(200);
            Thread.sleep(1000);
            account.deposit(-100); // Invalid deposit amount
            Thread.sleep(1000);
            account.withdraw(1500); // Insufficient funds for withdrawal
        }
}
