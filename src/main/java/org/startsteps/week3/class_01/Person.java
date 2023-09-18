package org.startsteps.week3.class_01;

import java.util.Objects;

// parent class (superclass)
public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {}

    // Constructor
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Methods
    public int getAge() {
        return age;
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
    }

    //    To implement equals() and hashCode(), you should consider the attributes that uniquely identify a person
    //    (e.g., name and age). These methods are used for object comparison and are essential when working with
    //    collections like HashSet or HashMap.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }


    // The toString() method is used to represent an object as a string. It's helpful for debugging and printing objects.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
