package org.startsteps.week15.day2.interview;

import java.util.Arrays;

public class TestSorting {
    //3 find the second highest number in an array?
    // input: { -3, 6, 2, 9, 7 }
    // output: 7
    public static void main(String[] args) {
        int[] array = { -3, 6, 2, 9, 7 };
        //bug1: if there are duplicates and these
        // duplicates are the highest number in the
        // array we will have wrong outputs

        //bug2: if there are less than 2 elements in the
        // array it will cause a ArrayIndexOutOfBoundsException
        Arrays.sort(array);
        int output = array[array.length-2];
        System.out.println(output);
        // complexity is O(N logN)
    }
}
