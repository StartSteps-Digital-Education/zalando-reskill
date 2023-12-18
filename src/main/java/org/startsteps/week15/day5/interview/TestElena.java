package org.startsteps.week15.day5.interview;

import java.util.Arrays;

public class TestElena {
    public static void main(String[] args) {
        // Write a Java program to find the maximum number inside the number in the window (size k) at each step in a
        // given array of integers with duplicate numbers. Move the window to the top of the array. (slide window)
        // Sample output:
        // {|1, 2, 3|, 4, 5, 6, 7, 8, 8} -> Return maximum 3
        // {1, |2, 3, 4|, 5, 6, 7, 8, 8} -> Return maximum 4
        // {1, 2, |3, 4, 5|, 6, 7, 8, 8} -> Return maximum 5
        // {1, 2, 3, |4, 5, 6|, 7, 8, 8} -> Return maximum 6
        // {1, 2, 3, 4, |5, 6, 7|, 8, 8} -> Return maximum 7
        // {1, 2, 3, 4, 5, |6, 7, 8|, 8} -> Return maximum 8
        // {1, 2, 3, 4, 5, 6, |7, 8, 8|} -> Return maximum 8
        // Result array {3, 4, 5, 6, 7, 8, 8}
        // Expected Output:
        // Original array: [1, 2, 3, 4, 5, 6, 7, 8, 8]
        //
        // Value of k: 3
        //
        // Result:
        // 2
        // 3
        // 4
        // 5
        // 6
        // 7
        // 8

        int k = 3;
        int j = 0;
        int[] arraySorted = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        int[] array = {1, 2, 5, 9, 5, 6, 1, 8, 1};
        int[] maximums = new int[array.length - k + 1];

        Arrays.sort(array);
        // if the array is sorted
        for (int i = 0; i < array.length-k+1; i++) {
            maximums[j++] = array[i+k-1];
        }

//        System.out.println(j);



        for (int i = 0; i<=maximums.length - 1; i++) {
            System.out.println(maximums[i]);
        }

//        for (int i = 0; i < array.length - k; i++) {
//            int localMaximum = array[i];
//            //array[i], array[i+1], ... arary[i+k-1] > MAX?
//            for(int j = i; j < k; j ++){
//                if(localMaximum<array[j])
//                    localMaximum = array[j];
//
//
//                // j = 2 => localMaximum = 3
//            }

//        }
    }
}
