package org.startsteps.week10.class_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankWithFixedThreadPool {
    private List<BankAccount> accounts;
    private ExecutorService executor;

    public BankWithFixedThreadPool() {
        this.accounts = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(3);
    }

    public void addAccount(int accountNumber, int initialBalance) {
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.add(account);
    }

    public void executeCustomerTransactions() {
        for (BankAccount account : accounts) {
            int transactionAmount = 200;
            Customer customer = new Customer(account, "Customer", transactionAmount, executor);
            executor.submit(customer);
        }
        executor.shutdown();
    }
    public BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}