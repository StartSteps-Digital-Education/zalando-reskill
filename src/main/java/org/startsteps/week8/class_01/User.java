package org.startsteps.week8.class_01;

public class User {
    String name, email, address, phoneNumber;
    int age;

    public void printUserDetails(){
        System.out.println("\nday1.User Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}