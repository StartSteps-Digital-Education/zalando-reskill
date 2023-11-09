package org.startsteps.week10.class_04.solid.task2.subtask2;


import org.startsteps.week10.class_04.solid.task1.AccountDetails;

class WithdrawalTransaction implements Withdrawable {
    @Override
    public void withdraw(AccountDetails account, int amount) {
        account.withdraw(amount);
    }
}
