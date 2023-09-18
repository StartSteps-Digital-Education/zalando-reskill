package org.startsteps.week2.class_04;

public class Expense {

    //    Expense Categories:
    //    [Groceries, Rent, Utilities, Transportation, Entertainment, Savings] - []
    //     - 6 categories 3 * 6

    // 100, 290, 839, 282, 374, 283 // july  = [][]
    // 100, 290, 839, 282, 374, 283 // august
    // 100, 290, 839, 282, 374, 283 // september


    // Total expense for the last 3 months
    // output: 2000
    //  1000
    //  1500


    // 2492
    public static void main(String[] args) {
        String[] expenseCategories = {"Rent", "Groceries", "Utilities", "Transportation", "Entertainment", "Savings"}; //6
        String[] months = {"January", "February", "March"};

        int[][] expenses = {
                {1000, 290, 282, 300, 500, 120},// Jan
                {1000, 290, 282, 300, 500, 120}, // Feb
                {1000, 290, 282, 300, 500, 120}  // Mar

        };

        for (int i = 0; i < expenses.length; i++) {
            // total of expense calculation
            int totalExpense = 0;
            for (int j = 0; j < expenses[i].length; j++) {
                totalExpense += expenses[i][j];
            }
            System.out.println(months[i] + "Total Expenses " + totalExpense + "€");
        }
    }
}
