package org.startsteps.week10.class_04.solid.task1;

import java.util.concurrent.Callable;

// Subtask 1.1
class TransactionProcessor implements Callable<Void> {
    private AccountDetails account;
    private int transactionAmount;

    public TransactionProcessor(AccountDetails account, int transactionAmount) {
        this.account = account;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public Void call() throws Exception {
        account.deposit(transactionAmount);
        return null;
    }
}

