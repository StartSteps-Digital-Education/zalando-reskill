package org.startsteps.week10.class_04.solid.task1;

// Subtask 1.2
class DepositTransaction implements Transaction {
    private int amount;
    private AccountDetails account;

    public DepositTransaction(AccountDetails account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void process() {
        if (amount > 0) {
            account.setBalance(account.getBalance()+ amount);
        }
    }
}


