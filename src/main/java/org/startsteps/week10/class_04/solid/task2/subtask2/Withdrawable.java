package org.startsteps.week10.class_04.solid.task2.subtask2;

import org.startsteps.week10.class_04.solid.task1.AccountDetails;

interface Withdrawable extends Transaction {
    void withdraw(AccountDetails account, int amount);
}
