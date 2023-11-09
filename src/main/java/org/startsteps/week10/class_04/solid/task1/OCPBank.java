package org.startsteps.week10.class_04.solid.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Subtask 1.2
public class OCPBank {
    private List<AccountDetails> accounts;
    private ExecutorService executor;

    public OCPBank() {
        this.accounts = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool();
    }

    public void addAccount(int accountNumber, int initialBalance) {
        AccountDetails account = new AccountDetails(accountNumber, initialBalance);
        accounts.add(account);
    }

    public Future<Void> executeTransactionAsync(AccountDetails account, Transaction transaction) {
        Callable<Void> transactionTask = () -> {
            transaction.process(account);
            return null;
        };

        return executor.submit(transactionTask);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}

