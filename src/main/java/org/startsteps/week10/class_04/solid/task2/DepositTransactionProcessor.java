package org.startsteps.week10.class_04.solid.task2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

import java.util.concurrent.*;

class DepositTransactionProcessor {
    private DepositTransaction depositTransaction;
    private ExecutorService executor;

    public DepositTransactionProcessor(DepositTransaction depositTransaction) {
        this.depositTransaction = depositTransaction;
        this.executor = Executors.newCachedThreadPool();
    }

    public Future<Void> processTransactionAsync(AccountDetails account, int amount) {
        Callable<Void> transactionTask = () -> {
            depositTransaction.deposit(account, amount);
            return null;
        };

        return executor.submit(transactionTask);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
