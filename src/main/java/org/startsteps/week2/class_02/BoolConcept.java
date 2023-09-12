package org.startsteps.week2.class_02;

import java.util.Scanner;

public class BoolConcept {

//    A     B         A | B    A & B   A ^ B   A || B    !A
//    false false     false    false   false   false     true
//    true  false     true     false   true    true      FALSE
//    false true      true     false   true    true      true
//    true  true      true     true    false   true      false

//    false || true => true  // true || true => true
//
//    | , & , ^ (XOR),  || (Short circuit), && (Short circuit)

    public static void main(String[] args)
    {
        int num1, num2;
        boolean bothEven;

        System.out.print("Enter First number: ");
        num1 = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.print("Enter Second number: ");
        num2 = Integer.parseInt(new Scanner(System.in).nextLine());

        bothEven = (num1 % 2 == 0) && (num2 % 2 == 0);

        System.out.println(bothEven ? "The numbers are bothEven" : "there's a number odd");
    }


}
