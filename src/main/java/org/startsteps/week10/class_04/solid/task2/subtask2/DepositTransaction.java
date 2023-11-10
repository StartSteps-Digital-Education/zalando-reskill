package org.startsteps.week10.class_04.solid.task2.subtask2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

class DepositTransaction implements Depositable {
    @Override
    public void deposit(AccountDetails account, int amount) {
        account.setBalance(account.getBalance() + amount);
    }
}
