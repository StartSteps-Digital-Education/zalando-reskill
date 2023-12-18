package org.startsteps.week16.day1;

import java.util.Arrays;

public class TestValentina {

    public static int countTriangles(int[] arr){
        int count = 0;
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 1; i--){

            int sideA = arr[i];
            int sideB = arr[i-1];

            for (int j = arr.length - 1; j >= 0; j--) {
                if(i == j || j == i -1) continue;
                int sideC = arr[j];
                if(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
                    System.out.println("sideA: "+sideA + " sideB: " +sideB+ " sideC: "+arr[j]);
                    count++;
                }
            }

            //int twoSides = arr[i] + arr[i+1]; // 6 and 7 twosides = 13
//            int j = arr.length - 1;
//            while (arr[i] - arr[j] > arr[k]);
//            for(int j = arr.length-1; j >= 0; j--){ // arr[j] = 9
//                int number = arr[i] - arr[j];
//            }

                //[ 6, 7, 9, 12, 16, 25, 30, 40 ]
                // 40 - 30 = 10
                // 25 >= 10 => triangle
                // 9 < 10

                //
        }

        // i = 40
        // j = 30, 25
        // k = 12,25,16,9,7,6

        //   n!/(k! * (n-k)!) n^k

        int n = arr.length;
        int k = 3;
//        count = factorial(n) / (factorial(k) * factorial(n-k));

        return count;


    }

    public static int factorial(int no) {
        int result = 1;
        for (int i = 1; i <= no ; i++) {
            result*=i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Write a Java program to count the number of possible triangles from a given unsorted array of positive
        // integers.
        // Note: The triangle inequality states that the sum of the lengths of any two sides of a triangle
        // must be greater than to the length of the third side.

        //Original Array : [6, 7, 9, 16, 25, 12, 30, 40] Total number of triangles:  17
        //Sorted Array: [6, 7, 9, 12, 16, 25, 30, 40]
        // New Array [13, 9, 12, 16, 25, 30, 40]
        // 6, 7, 9
        // 6 + 7 >= 9 (true)
        // 7 + 9 >= 6 (true)
        // 6 + 9 >= 7 (true)

        // 10, 0, 1
        // what about negatives? no negatives in the array

        // 6 + 7 = 13
        int[] arr = {6, 7, 9};//, 16, 25, 12, 30, 40};
        System.out.println(countTriangles(arr));

    }
}
