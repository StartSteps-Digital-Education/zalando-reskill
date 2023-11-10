package org.startsteps.week10.class_04.solid.task1;

import java.util.concurrent.Callable;

// Subtask 1.1
class DepositTransactionProcessor implements Callable<Void> {
    private AccountDetails account;
    private int transactionAmount;

    public DepositTransactionProcessor(AccountDetails account, int transactionAmount) {
        this.account = account;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public Void call() throws Exception {
        account.setBalance(account.getBalance()+transactionAmount);
        return null;
    }
}

