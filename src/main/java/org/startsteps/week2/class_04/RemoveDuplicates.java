package org.startsteps.week2.class_04;

import java.util.Arrays;

public class RemoveDuplicates {


//    Write a Java program to remove duplicate elements from a given array and return the updated array length.
//    Sample array: [20, 20, 30, 40, 50, 50, 50]
//    After removing the duplicate elements the program should return 4 as the new length of the array.


    public static void main(String[] args) {
        int[] arr = {20, 30, 40, 50, 20, 50, 50};
        int newLength = removeDuplicates(arr);
        System.out.println("Updated Array Length: " + newLength);
    }



    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return 1;
        }

        // 20, 30, 40, 50, 20, 50, 50
        // 20, 20, 30, 40, 50, 50, 50

        Arrays.sort(arr); // [0, 10]

        int uniqueCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueCount++; // 1 , ...
            }
            // end up here
        }

        return uniqueCount;
    }
}
