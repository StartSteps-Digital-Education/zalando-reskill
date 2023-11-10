package org.startsteps.week10.class_04.solid.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Subtask 1.1
public class SolidBank {
    private List<AccountDetails> accounts;
    private ExecutorService executor;

    public SolidBank() {
        this.accounts = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool();
    }

    public void addAccount(int accountNumber, int initialBalance) {
        AccountDetails account = new AccountDetails(accountNumber, initialBalance);
        accounts.add(account);
    }

    public Future<Void> executeCustomerTransactionAsync(AccountDetails account, int transactionAmount) {
        DepositTransactionProcessor transactionProcessor = new DepositTransactionProcessor(account, transactionAmount);
        return executor.submit(transactionProcessor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
