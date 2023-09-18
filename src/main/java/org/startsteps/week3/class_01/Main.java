package org.startsteps.week3.class_01;

public class Main {
    public static void main(String[] args) {
        // instance, reference
        Person person1 = new Person("Alice", 30, "123 Main St");
        Person person2 = new Person("Bob", 25, "456 Elm St");

        // Casting is the process of converting an object reference from one class type to another.
        // You can cast an object to a subclass or a superclass.
        Person person = new Employee(); // Assuming Employee is a subclass of Person
        Employee employee = (Employee) person; // Casting person to Employee


        Car vehicle1 = new Car();
        Vehicle vehicle2 = new Bicycle();

        if (vehicle1 instanceof Car) {
            vehicle1.identify();
        }

        if (vehicle2 instanceof Bicycle) {
            vehicle2.identify();
        }
    }
}
