package org.startsteps.week10.class_04.solid.task2.subtask2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

class TransactionProcessor {
    public void processTransaction(AccountDetails account, int amount, Depositable depositable) {
        depositable.deposit(account, amount);
    }

    public void processTransaction(AccountDetails account, int amount, Withdrawable withdrawable) {
        withdrawable.withdraw(account, amount);
    }
}
