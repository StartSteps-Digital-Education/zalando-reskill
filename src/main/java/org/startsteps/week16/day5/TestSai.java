package org.startsteps.week16.day5;

public class TestSai {

    public static void main(String[] args) {

        int n = 40 ;
        for(int i = 1; i<=n; i++){

            for (int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();

        }

        System.out.println("         Merry Christmas Everyone !!!");
        /**
         * Create a Java program that draws a Christmas Tree of size n:
         * Input: n=5:
         * Output:
         *
         *
         *       *
         *      ***
         *     *****
         *    *******
         *   *********
         *
         *
         * n=6:
         *
         *       *
         *      ***
         *     *****
         *    *******
         *   *********
         *  ***********
         */


    }
}
