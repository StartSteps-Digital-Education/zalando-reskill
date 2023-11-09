package org.startsteps.week10.class_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        // Task 1 start
        // Subtask 1.1 start
        Bank bank = new Bank();

        // Adding accounts
        bank.addAccount(1, 1000);
        bank.addAccount(2, 1500);

        // Executing customer transactions using ExecutorService
        bank.executeCustomerTransactions();
        // Subtask 1.1 end


        // Subtask 1.2 start
        useBankWithFixedThreadPool();

        useBankWithCachedThreadPool();
        // Subtask 1.2 end
        // Task 1 end

        // Task 2
        // missing for now
        // Task 2 end

        // Task 3 start
        // Subtask 1&2 start
        try {
            callBankWithFuture();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Subtask 1&2 end
        // Task 3 end

        // Task 4 start
        try {
            stressTestBank();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Task 4 end
    }

    private static void stressTestBank() throws ExecutionException, InterruptedException {
        BankStressTest bank = new BankStressTest();

        // Adding accounts
        bank.addAccount(1, 1000);
        bank.addAccount(2, 1500);

        // Executing a large number of customer transactions asynchronously
        int totalTransactions = 1000;
        List<Future<Void>> transactionFutures = new ArrayList<>();

        for (int i = 0; i < totalTransactions; i++) {
            int accountNumber = (i % 2) + 1; // Alternating between account 1 and 2
            int transactionAmount = new Random().nextInt(400) + 200; // 200-600 random value transactions
            if (new Random().nextBoolean()) { // Randomly do deposit or withdraw
                transactionFutures.add(bank.executeCustomerTransactionAsyncDeposit(accountNumber, transactionAmount));
                System.out.println("Account "+ accountNumber +" doing transaction no." + (i+1) + " DEPOSIT with amount: $"+transactionAmount);
            } else {
                transactionFutures.add(bank.executeCustomerTransactionAsyncWithdraw(accountNumber, transactionAmount));
                System.out.println("Account "+ accountNumber +" doing transaction no." + (i+1) + " WITHDRAW with amount: $"+transactionAmount);
            }
        }

        // Wait for all transactions to complete
        for (Future<Void> future : transactionFutures) {
            future.get();
        }

        // Verify account balances for data consistency
        for (BankAccount account : bank.getAccounts()) {
            System.out.println("Account " + account.getAccountNumber() + " balance: $" + account.getBalance());
        }

        // Shutdown the executor
        bank.shutdownExecutor();
    }

    private static void callBankWithFuture() throws ExecutionException, InterruptedException {
        BankWithFuture bankWithFuture = new BankWithFuture();

        // Adding accounts
        bankWithFuture.addAccount(1, 1000);
        bankWithFuture.addAccount(2, 1500);

        // Executing customer transactions asynchronously and obtaining Future objects
        Future<Void> transaction1 = bankWithFuture.executeCustomerTransactionAsync(1, 200);
        Future<Void> transaction2 = bankWithFuture.executeCustomerTransactionAsync(2, 300);

        // Wait for the transactions to complete
        transaction1.get();
        transaction2.get();

        // Shutdown the executor
        bankWithFuture.shutdownExecutor();
    }

    private static void useBankWithCachedThreadPool() {
        BankWithCachedThreadPool bankWithCachedThreadPool = new BankWithCachedThreadPool();

        // Adding accounts
        bankWithCachedThreadPool.addAccount(1, 1000);
        bankWithCachedThreadPool.addAccount(2, 1500);

        // Executing customer transactions using ExecutorService
        bankWithCachedThreadPool.executeCustomerTransactions();
    }

    private static void useBankWithFixedThreadPool() {
        BankWithFixedThreadPool bankWithFixedThreadPool = new BankWithFixedThreadPool();

        // Adding accounts
        bankWithFixedThreadPool.addAccount(1, 1000);
        bankWithFixedThreadPool.addAccount(2, 1500);

        // Executing customer transactions using ExecutorService
        bankWithFixedThreadPool.executeCustomerTransactions();
    }
}

