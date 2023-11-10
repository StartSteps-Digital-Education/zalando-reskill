package org.startsteps.week10.class_04.solid.task1;

import java.util.concurrent.Callable;

// Subtask 1.1
class WithdrawTransactionProcessor implements Callable<Void> {
    private int transactionAmount;
    private Transaction transaction;

    public WithdrawTransactionProcessor(Transaction transaction, int transactionAmount) {
        this.transactionAmount = transactionAmount;
        this.transaction = transaction;
    }

    @Override
    public Void call() throws Exception {
        transaction.process();
        return null;
    }
}

