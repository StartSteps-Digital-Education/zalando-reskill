package org.startsteps.week10.class_01.task03;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(int accountNumber, int initialBalance) {
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.add(account);
    }

    public BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}