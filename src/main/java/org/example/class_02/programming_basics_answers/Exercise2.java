package org.example.class_02.programming_basics_answers;

public class Exercise2 {
    public static void main(String[] args) {
        //Declare two integer variables, a and b, initialize them to 5 and 10, respectively.
        int a = 5, b = 10;

        // Swap their values without using a third variable.
        a = a + b;
        b = a - b;
        a = a - b;

        //Print the new values of a and b.
        System.out.println("a: " + a);
        System.out.println("b: " + b);


        //Create a boolean variable named isSunny and set it to true. Print the value
        Boolean isSunny = true;
        System.out.println(isSunny);


        //Create a char variable and assign your initial to it. Print it
        char initial= 'N';
        System.out.println(initial);



        //Declare two float variables and assign any two decimal numbers to them. Print their values.
        float num1 = 2.5f;
        float num2 = 3.7f;
        System.out.println("num1:" + num1 + ", num2: " + num2);


    }
}
