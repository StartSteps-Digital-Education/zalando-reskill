package org.startsteps.week10.class_01.task01;

// Exercise 1
class Customer implements Runnable {
    private BankAccount account;
    private String name;
    private int depositAmount;

    public Customer(BankAccount account, String name, int depositAmount) {
        this.account = account;
        this.name = name;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        System.out.println(name + " is depositing $" + depositAmount);
        account.deposit(depositAmount);
        System.out.println(name + "'s new balance: $" + account.getBalance());
    }
}
