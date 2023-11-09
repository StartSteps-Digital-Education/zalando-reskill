package org.startsteps.week10.class_04.solid.task2.subtask2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<AccountDetails> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public AccountDetails getAccount(int index) {
        return accounts.get(index);
    }

    public void addAccount(int accountNumber, int initialBalance) {
        AccountDetails account = new AccountDetails(accountNumber, initialBalance);
        accounts.add(account);
    }

    public void processDeposit(AccountDetails account, int amount, Depositable depositable) {
        TransactionProcessor processor = new TransactionProcessor();
        processor.processTransaction(account, amount, depositable);
    }

    public void processWithdrawal(AccountDetails account, int amount, Withdrawable withdrawable) {
        TransactionProcessor processor = new TransactionProcessor();
        processor.processTransaction(account, amount, withdrawable);
    }
}
