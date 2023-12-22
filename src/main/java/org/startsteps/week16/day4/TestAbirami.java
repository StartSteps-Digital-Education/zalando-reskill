package org.startsteps.week16.day4;

import java.util.*;

public class TestAbirami {
    // In mathematics, the sieve of Eratosthenes is an ancient algorithm
    // for finding all prime numbers up to any given limit.
    // Write a Java program to print all primes smaller
    // than or equal to any given number.


    // prime?  13|13 = 1  13|1 = 13
    // 14
    // 14|1 = 14;
    // 14|2 = 7;
    // 14|7 = 2;
    // 14|14 = 1;

    public static void main(String[] args) {
        int input = 99999; // >1
        // 2(p), 3(p), 4, 5(p), 6, 7(p), 8
        // p - prime
        // x - not prime

        // 2p 3p 4x 5p 6x 7p 8x 9x 10x 11p 12x 13p 14x 15x 16x 17p 18x 19p 20x 21x 22x 23p 24x 25x 26x 27x 28x 29p 30x 31p

        // 32 input
        // 2 3 5 7 11 13 17 19 23 29 31
        Map<Integer, Boolean> arr = new HashMap();
        for (int i = 2; i < input; i++) {
            arr.put(i, true);
        }

        for (int i = 2; i < arr.size()+2; i++) {
            //arr.put(i, false);
            for (int j = i + i; j <= input; j = j + i){
                arr.put(j, false);
            }
        }

        for (int i = 2; i < arr.size()+2; i++) {
            if (arr.get(i))
                System.out.print(i + " ");

        }
        System.out.println(isPrime(86531));

    }

    // 41
    // 2 40
    // 2 20
    // 2 sqrt(41)


    public static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
        int i;
        for (i = 2; i < Math.sqrt(number); i++){ // i<number (1) <- i<number/2 (2) <- i<Math.sqrt(number) (3)
            if(number % i == 0) return false;
        }
        System.out.println("i is "+ i);
        return true;
    }
}
