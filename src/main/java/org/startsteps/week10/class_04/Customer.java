package org.startsteps.week10.class_04;

import java.util.concurrent.ExecutorService;

// Exercise 1
class Customer implements Runnable {
    private final ExecutorService executor;
    private BankAccount account;
    private String name;
    private int depositAmount;

    public Customer(BankAccount account, String name, int depositAmount, ExecutorService executor) {
        this.account = account;
        this.name = name;
        this.depositAmount = depositAmount;
        this.executor = executor;
    }

    @Override
    public void run() {
        System.out.println(name + " is depositing $" + depositAmount);
        executor.submit(() -> account.deposit(depositAmount));
        System.out.println(name + "'s new balance: $" + account.getBalance());
    }
}
