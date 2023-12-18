package org.startsteps.week15.day5.interview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestHan {
    public static void main(String[] args) {
        // Write a Java program to find the k largest elements in a given array. Elements in the array can be in any order.
        // Expected Output:
        // Original Array (assume that an array contains at least one element and the k>=1):
        // [1, 4, 17, 7, 25, 3, 100]
        // 3 largest elements of the said array are:
        // 100 25 17
//        System.out.println(Arrays.toString(taskFour(3, new int[]{100, 4, 17, 7, 25, 3, 100})));
//        System.out.println(taskFourWithoutDuplicates(3, new int[]{100, 4, 17, 7, 25, 3, 100}));
        findLargestElements(new int[]{99, 4, 17, 7, 25, 3, 100}, 4);
    }

    public static Set<Integer> taskFourWithoutDuplicates(int k, int[] arr){
        Set<Integer> uniqueValues = new TreeSet<Integer>();
        Arrays.sort(arr);
        for (int i = 0; i <= k; i++) {
            uniqueValues.add(arr[arr.length-1 -i]);
        }
        return uniqueValues;
    }
    public static int[] taskFour(int k, int[] arr){
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i <result.length; i++) {
            result[i] = arr[arr.length-1 -i];
        }
        return  result;
    }

    public static int findIndexOfSmallest(int[] arr, int k) {
        int indexOfSmallest = 0;
        for (int j = 1; j < k; j++) {
            if (arr[j] < arr[indexOfSmallest]) {
                indexOfSmallest = j;
            }
        }
        return indexOfSmallest;
    }


    public static void findLargestElements(int[] arr2, int k) {
        int[] arr = arr2;
        int indexOfSmallest = findIndexOfSmallest(arr, k);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > arr[indexOfSmallest]) {
                arr[indexOfSmallest] = arr[i];
                indexOfSmallest = findIndexOfSmallest(arr, k);
            }
        }
            for (int j = 0; j < k; j++) {
                System.out.println(arr[j]);
            }
    }
}
