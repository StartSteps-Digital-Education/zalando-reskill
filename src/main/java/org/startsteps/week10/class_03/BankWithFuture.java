package org.startsteps.week10.class_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class BankWithFuture {
    private List<BankAccount> accounts;
    private ExecutorService executor;

    public BankWithFuture() {
        this.accounts = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool();
    }

    public void addAccount(int accountNumber, int initialBalance) {
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.add(account);
    }

    public Future<Void> executeCustomerTransactionAsync(int accountNumber, int transactionAmount) {
        Callable<Void> transactionTask = () -> {
            BankAccount account = getAccount(accountNumber);
            if (account != null) {
                account.deposit(transactionAmount);
            }
            return null;
        };

        return executor.submit(transactionTask);
    }

    public BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
