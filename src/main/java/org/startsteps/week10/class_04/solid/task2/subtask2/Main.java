package org.startsteps.week10.class_04.solid.task2.subtask2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(1, 1000);
        bank.addAccount(2, 1500);

        Depositable depositTransaction = new DepositTransaction();
        Withdrawable withdrawalTransaction = new WithdrawalTransaction();

        // Process transactions
        AccountDetails account1 = bank.getAccount(1);
        AccountDetails account2 = bank.getAccount(2);

        bank.processDeposit(account1, 200, depositTransaction);
        bank.processWithdrawal(account2, 300, withdrawalTransaction);

        // Verify account balances
        System.out.println("Account 1 balance: $" + account1.getBalance());
        System.out.println("Account 2 balance: $" + account2.getBalance());
    }
}
