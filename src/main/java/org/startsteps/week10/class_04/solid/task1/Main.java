package org.startsteps.week10.class_04.solid.task1;

public class Main {

    public static void main(String[] args) {
        OCPBank bank = new OCPBank();

        AccountDetails account = new AccountDetails(1, 2000);
        bank.executeTransactionAsync(account, new WithdrawalTransaction(1100));
    }
}
