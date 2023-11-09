package org.startsteps.week10.class_04.solid.task1;

// Subtask 1.2
class DepositTransaction implements Transaction {
    private int amount;

    public DepositTransaction(int amount) {
        this.amount = amount;
    }

    @Override
    public void process(AccountDetails account) {
        account.deposit(amount);
    }
}


