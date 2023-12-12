package org.startsteps.week15.day2.interview;

import java.util.HashMap;

public class TestDuplicates {

    public static void main(String[] args) {
        //2 Find all letter duplicates in a String
        // example input:
        // Hello World
        // example output:
        // l=3
        // o=2
        String word = "the little! re4d fox jump4s! over the lazy\n\n\t\t";
        HashMap<Character, Integer> duplicates = new HashMap<>();
        char[] arrOfChar = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            int oldValue = duplicates.getOrDefault(arrOfChar[i], 0);
            duplicates.put(arrOfChar[i], oldValue + 1);
        }

        for(Character character : duplicates.keySet()){
            int numOfDuplicates = duplicates.get(character);
            if (numOfDuplicates > 1 && isALetter(character)) {
                // o = 2
                // l = 3
                System.out.println(character + " = " + numOfDuplicates);
            }
        }

        // Big O notation? O(N) + O(N) = O(N) O(1)
    }

    private static boolean isALetter(Character character) {
        return (Integer.valueOf(character) >= Integer.parseInt("A") &&
                Integer.valueOf(character) <= Integer.parseInt("Z")) ||
                (Integer.valueOf(character) >= Integer.parseInt("a") &&
                        Integer.valueOf(character) <= Integer.parseInt("z"));
    }
}
