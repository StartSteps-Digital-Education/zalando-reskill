package org.startsteps.week16.day1;

public class TestMariia {
    public static void main(String[] args) {

        // 2. Write a Java program to count the occurrences of a given string in another given string.
        // 'aa' has occurred 3 times in 'abcd abc aabc baa abcaa'

        // 'mahi' has occurred 4 times in 'mahi mahi mahi mahinalno'

        // 'abcd' has occurred 1 times in 'abcd'

        String testString = "bbaa aaa aaaa";
        String input = "aaa";
//        String output = "'aa' has occurred 3 times in 'abcd abc aabc baa abcaa'";
        int count = 0;
        for (int i = 0; i <= testString.length() - input.length(); i++) {
          String substring = testString.substring(i, i + input.length());
            if (substring.equals(input)){
              count = count + 1;
            }
        }
        System.out.println(input+" has occurred " + count +" times in " +testString );
//        "bbaaaaaaaaa" "aaa"
//            "aaaaaa" "aaa"
//            "aaa" "aaa"
//            "" "aaa"


    }

    public static int countOcurrance(String string1, String string2){
        int count = 0;
        while(string1.indexOf(string2)!=-1){
            string1 = string1.substring(string1.indexOf(string2) + 1);
            count ++;
        }
        return count;
    }
}
