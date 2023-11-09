package org.startsteps.week10.class_04.solid.task2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

import java.util.concurrent.*;

class WithdrawalTransactionProcessor {
    private WithdrawalTransaction withdrawalTransaction;
    private ExecutorService executor;

    public WithdrawalTransactionProcessor(WithdrawalTransaction withdrawalTransaction) {
        this.withdrawalTransaction = withdrawalTransaction;
        this.executor = Executors.newCachedThreadPool();
    }

    public Future<Void> processTransactionAsync(AccountDetails account, int amount) {
        Callable<Void> transactionTask = () -> {
            withdrawalTransaction.withdraw(account, amount);
            return null;
        };

        return executor.submit(transactionTask);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
