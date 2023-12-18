package org.startsteps.week15.day5.interview;

public class TestJulia {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        String sum = addTwoStrNum(num1, num2);
        System.out.println("num1 (" + num1 + ")" + " + " + "num2( " + num2 + ")" + " = " + sum);
        // Write a Java program to two non-negative integers num1 and num2 represented as strings,
        // return the sum of num1 and num2.
        // Expected Output:
        // "123" + "456" = 579
    }

    public static String addTwoStrNum(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digitStrNum1 = 0;
            int digitStrNum2 = 0;

            if (i >= 0) {
                digitStrNum1 = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                digitStrNum2 = num2.charAt(j) - '0';
                j--;
            }
            int sum = digitStrNum1 + digitStrNum2 + carry;
            carry = sum / 10; // sum = 18 => carry = 18/10 = 1
            result.insert(0, sum % 10); // sum = 18 % 10 = 8
        }
        return result.toString();
    }
}
