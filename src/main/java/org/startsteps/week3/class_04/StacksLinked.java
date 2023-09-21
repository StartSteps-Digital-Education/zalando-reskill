package org.startsteps.week3.class_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StacksLinked {
    public static void main(String[] args) {
        // collection framework
        LinkedList<Integer> numLinkedList = new LinkedList<>();
        numLinkedList.add(5);
        numLinkedList.add(10);
        numLinkedList.add(34);

        System.out.println(numLinkedList);
        numLinkedList.add(2, 15);
        System.out.println(numLinkedList);

        numLinkedList.remove();
        System.out.println(numLinkedList);

        numLinkedList.remove(2);
        System.out.println(numLinkedList);

        // head -> 5 -> 10 -> 34 -> null


        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Musie");
        nameList.add("Justine");
        System.out.println(nameList);

        ;
        System.out.println(nameList.get(1));
        nameList.remove("Musie");
        System.out.println(nameList);

        // Stack FILO
        Stack<String> elements = new Stack<>();
        elements.add("plate 1");
        elements.add("plate 2");
        elements.add("plate 3");
        System.out.println(elements);
        System.out.println(elements.pop());
        System.out.println(elements);
        elements.push("plate 4");
        System.out.println(elements);

//
//        Create a Java program that:
//        Initializes a LinkedList of strings.
//                Adds the following names to the LinkedList: "Alice," "Bob," "Charlie," "David," "Eve."
//        Prints the LinkedList.
//                Removes "Charlie" from the LinkedList.
//                Prints the modified LinkedList.
//                Checks if "Bob" is in the LinkedList and prints the result (true/false).

        LinkedList<String> nameLinkedList = new LinkedList<>();
        nameLinkedList.add("Alice");
        nameLinkedList.add("Bob");
        nameLinkedList.add("Charlie");
        nameLinkedList.add("David");
        nameLinkedList.add("Eve");

        System.out.println(nameLinkedList);
        nameLinkedList.remove("Charlie");

        System.out.println(nameLinkedList);
        boolean isBobExists = nameLinkedList.contains("Bob");
        System.out.println(isBobExists);

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        int element = arrayList.get(0); // Access by index
//
//
//        Stack<String> stack = new Stack<>();
//        stack.push("A");
//        stack.push("B");
//        String popped = stack.pop(); // Removes and returns "B"
//
//
//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add("A");
//        linkedList.add("B");
//        linkedList.removeFirst(); // Removes the first element "A"
    }
}
