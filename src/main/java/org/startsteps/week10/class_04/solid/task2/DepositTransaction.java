package org.startsteps.week10.class_04.solid.task2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

// Subtask 2.1 Interface Segregation Principle (ISP):
interface DepositTransaction {
    void deposit(AccountDetails account, int amount);
}

