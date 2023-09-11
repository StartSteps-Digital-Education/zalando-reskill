package org.startsteps.week1.class_02;

public class Basics {
    public static void main(String[] args) {
        //Declare two float variables and initialize them to any two numbers.
        //Print the sum, difference, product, and quotient of these numbers.
        float number1 = 2f;
        float number2 = 2f;
        float sum = number1 + number2;
        float subtraction = number2 - number1;
        float product = number1 * number2;
        float division = number2 / number1;

        System.out.println(sum);
        System.out.println(subtraction);
        System.out.println(product);
        System.out.println(division);


        // Declare an integer variable and initialize it to any number.
        // Use the modulus operator to find out if the number is even or odd.

        int number=12;
        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }

        // 	Write a Java program to calculate the area of a circle with a given radius.
        // 	Use the formula Area = π * radius * radius. You can use Math.PI for the value of π.
        double radius = 5;
        double area = Math.PI * Math.pow(radius, 2.0);
        System.out.println("The area is even" + area);


        // 	Calculate the average of 3 numbers
        int n1=5;
        int n2=7;
        int n3=15;

       double average=(n1+n2+n3)/3.0;

       System.out.println("The average is " + average);

       // int -> long -> double

        // Task: Calculate the total cost of items in the
        // shopping cart with discounts and display the result to the user.
        // 5 biscuits, 3 bananas => 5 . 2 euros,
        // 3 . 0.5 euros    // 0.50  (discount)
        // totalCost = (( 3 * 0.5 ) + ( 5 * 2 )) - (0.50)


        // Define the prices and quantities of items
        double biscuitPrice = 2.0;    // Price per biscuit in euros
        double bananaPrice = 0.5;    // Price per banana in euros
        int biscuitQuantity = 5;     // Quantity of biscuits
        int bananaQuantity = 3;      // Quantity of bananas
        double discount = 0.50;      // Discount amount in euros

        // Calculate the total cost before discount
        double totalCostBeforeDiscount = (biscuitPrice * biscuitQuantity) + (bananaPrice * bananaQuantity);

        // Apply the discount
        double totalCostAfterDiscount = totalCostBeforeDiscount - discount;

        // Display the result to the user
        System.out.println("Total cost before discount: " + totalCostBeforeDiscount + " euros");
        System.out.println("Discount applied: " + discount + " euros");
        System.out.println("Total cost after discount: " + totalCostAfterDiscount + " euros");
    }
}
