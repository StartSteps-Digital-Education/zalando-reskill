package org.startsteps.week15.day2.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {


//1 What will the following for loops do

    public static void main1(String[] args) {
//        for (;;) {
//            System.out.println("First for loop");
//        }

//        for( ; true; ){
//            System.out.println("Second for loop");
//        }

//        for (; false; ) {
//            System.out.println("Third for loop");
//        }

//        for ( ;2 == 2; ) {
//            System.out.println("Fourth for loop");
//        }

//        for (int i = 1; i >= 1; i++) {
//            System.out.println("Fifth for loop");
//        }
    }












//2 Find all letter duplicates in a String
// example input:
// Hello World
// example output:
// l=3
// o=2


    //2 Solution
    public static void main(String[] args) {
        String str = "Hello World";
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

//3 find the second highest number in an array?
// input: { 3, 6, 2, 9, 7 }
// output: 7

























//3 solution

    public static void main3(String[] args) {
        int[] arr = { 3, 6, 2, 9, 7 };
        Arrays.sort(arr);
        System.out.println("Second highest number: " + arr[arr.length - 2]);
    }



    //4 find the largest and smallest number in an array of integers in Java?

    public static void main4(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
// Find the maximum and minimum numbers
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Largest number: " + max);
        System.out.println("Smallest number: " + min);
    }




    //5 algorithmic problem:

    // A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way
    // to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair
    // number will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be handed to each
    // prisoner sequentially around the table until all have been distributed.
    // The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes
    // awful. Determine the chair number occupied by the prisoner who will receive that candy.

    // Example: n = 4 (jailers), m = 6 (candy), s = 2 (starting chair)

    // Output: There are 4 prisoners, 6 pieces of candy and distribution starts at chair 2. The prisoners arrange themselves in seats numbered 1 to 4.
    // Prisoners receive candy at positions 2 3 4 1 2 3. The prisoner to be warned sits in chair number 3.

    public static void main5(String[] args) {
        int numberOfPrisoners = 5;
        int numberOfTreats = 2;
        int startChair = 1;

        int lastChair = findLastChair(numberOfPrisoners, numberOfTreats, startChair);
        System.out.println("The last chair is: " + lastChair);
    }

    static int findLastChair(int numberOfPrisoners, int numberOfTreats, int startChair){
        int lastPrisoner = (startChair + numberOfTreats - 1) % numberOfPrisoners;

        // If the result is 0, it means the last prisoner is the last one in the sequence
        if (lastPrisoner == 0) {
            return numberOfPrisoners;
        } else {
            return lastPrisoner;
        }
    }


}
