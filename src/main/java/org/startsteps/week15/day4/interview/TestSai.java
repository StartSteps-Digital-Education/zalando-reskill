package org.startsteps.week15.day4.interview;

import java.util.ArrayList;

public class TestSai {

    public static void main(String[] args) {
        // Write a Java program to find the length of the longest consecutive sequence
        // in a given array of integers.
        //
        // Original array: [1, 1, 2, 3, 3, 4, 5, 2, 4, 5, 6, 7, 8, 6, -1, -2]

        // Original array: [1, 1, 2, 3, 3, 4, 5, 2, 4, 5, 6, 7, 8, 9, 6, -1, -2]
        // Output: 7
        // [1, 1, 2, 3, 3, 4, 5]
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 2, 4, 5, 6, 7, 8, 6, -1, -2, -3, -4, -5, -6, -7, -8, -8, -8, -8};
        int n = 1;
        int[] AscSequences = new int[100];
        int[] DscSequences = new int[100];
        int indexAscSeq = 0;
        int indexDscSeq = 0;


            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1] || arr[i] + 1 == arr[i + 1]) {
                    n = n + 1;
                } else {
                    AscSequences[indexAscSeq++] = n;
                    n = 1;
                }
            }
            AscSequences[indexAscSeq++] = n;
            n = 1;

            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] == arr[i + 1]) || (arr[i] - 1 == arr[i + 1])) {
                    n = n + 1;
            } else {
                DscSequences[indexDscSeq++] = n;
                n = 1;
               }
            }
            DscSequences[indexDscSeq++] = n;
        int result = 0;
        for (int j=0 ; j<= indexAscSeq ; j++ ){
            if(AscSequences[j] > result){
                result = AscSequences[j];
            }
        }

        for (int j=0 ; j<= indexDscSeq ; j++ ){
            if(DscSequences[j] > result){
                result = DscSequences[j];
            }
        }
        System.out.println("Result is: " + result);


        // O(n) + O(n) = O(n)

//        7    [0] result = 7
//        1
//        5
//        1
//        1
//        0

        for (int a = 0; a < DscSequences.length; a++){
//            System.out.println(DscSequences[a]);
        }
//        System.out.println("Sequence size is: " + n);
    }
}
