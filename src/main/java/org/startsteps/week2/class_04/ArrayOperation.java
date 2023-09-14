package org.startsteps.week2.class_04;

import java.util.Arrays;

public class ArrayOperation {
    public static void main(String[] args) {
        int[] num1 = new int[5];
        int[] num2 = { 12, 19, 9, 1 , 3, 1};
        // access
//        num2[2]
//        // modify
//        num[2] = 10;
//
//        // finding the length
//        num2.length

        // iterating // enhanced for loop
        for(int n: num2) {
            System.out.println(n);
        }

        // a copy of an array
        int[] num3 = Arrays.copyOf(num2, num2.length - 2);

        // searching
        int searchValue = 1;
        int index = Arrays.binarySearch(num2, searchValue); // 4

        System.out.println(index);

        // sort
        Arrays.sort(num2);
        System.out.println(Arrays.toString(num2));


    }
}
