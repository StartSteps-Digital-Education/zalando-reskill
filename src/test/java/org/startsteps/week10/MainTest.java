package org.startsteps.week10;

import org.junit.jupiter.api.Test;
import org.startsteps.week10.class_04.solid.task1subtaskOne.AccountDetails;
import org.startsteps.week10.class_04.solid.task1subtaskOne.PlaceholderDepositTransaction;
import org.startsteps.week10.class_04.solid.task1subtaskOne.Transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    @Test
    public void testIfTransactionIsExecuted(){
        AccountDetails ac = new AccountDetails(1, 1000);
        Transaction testTransaction = new PlaceholderDepositTransaction();

        int newValue = testTransaction.process(ac, 1000);

        assertEquals(2000, newValue);
    }
}
