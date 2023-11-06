package org.startsteps.week10.class_01.task03;

public class ExerciseOne {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        // Adding accounts
        bank.addAccount(1, 1000);
        Thread.sleep(1000);
        bank.addAccount(2, 1500);
        Thread.sleep(1000);

        // Performing transactions
        BankAccount account1 = bank.getAccount(1);
        Thread.sleep(1000);

        BankAccount account2 = bank.getAccount(2);
        Thread.sleep(1000);


        if (account1 != null && account2 != null) {
            // Simulating transactions
            Thread depositThread = new Thread(() -> {
                account1.deposit(200);
                account2.deposit(300);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread withdrawThread = new Thread(() -> {
                account1.withdraw(150);
                account2.withdraw(250);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            depositThread.start();
            withdrawThread.start();
        }
    }
}



