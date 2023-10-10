package org.startsteps.week6.class_02;

import java.util.ArrayList;
import java.util.List;

public class GenericsEx {
    // They allow you to write code that can work with different types
    // while preserving type safety.


    // class, interface, methods, wildcards (?)


    // Write a method called printList that accepts a list of objects
    // of any type and prints their toString() representations.


//    You can use generics to make the
//    generator flexible and allow it to work with different types of names.
//    Here's a simple example of a generic child name generator:


// Generate a generic method called printArray that takes an array of
// any type and prints its elements.

    public static <T, U> Pair<T, U> makePairs(T first, U second) {
        return new Pair<>(first, second);
    }

    public static <T> void printArray(T[] array) {
        for(T element: array) {
            System.out.println(element + " ");
        }
    }

    public static void printList(List<?> items) {
        for (Object item: items) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Justine");
        printList(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        printList(numbers);

        // make pairs
        Pair<String, Integer> nameAgePair = makePairs("Alice", 25);
        Pair<Double, Boolean> scorePassedPair = makePairs(96.5, true);

        System.out.println("Name: " + nameAgePair.getFirst() + " Age: " + nameAgePair.getSecond());
        System.out.println("Score: " + scorePassedPair.getFirst() + " Passed: " + scorePassedPair.getSecond());


        // products generics
        ShoppingCart<ElectronicProduct> electronicCart = new ShoppingCart<>();
        electronicCart.addProduct(new ElectronicProduct("Laptop", 999.99, "Toshiba"));

        ShoppingCart<ClothingProduct> clothingCart = new ShoppingCart<>();
        clothingCart.addProduct(new ClothingProduct("T-Shirt", 19.99, "Medium"));

        // Print the products in each cart
        System.out.println("Electronic Cart:");
        for (ElectronicProduct electronicProduct : electronicCart.getProducts()) {
            System.out.println(electronicProduct.getName() + " - " + electronicProduct.getBrand());
        }

        System.out.println("\nClothing Cart:");
        for (ClothingProduct clothingProduct : clothingCart.getProducts()) {
            System.out.println(clothingProduct.getName() + " - " + clothingProduct.getSize());
        }
    }




    // You can create generic classes and interfaces by
    // specifying one or more type parameters within angle brackets (<>)
    // when declaring them.


//    Wildcards, denoted by ?, allow you to work with unknown types in
//    generic code.


}
