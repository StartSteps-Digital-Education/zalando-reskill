package org.startsteps.week2.class_01;

public class SamplePerson {
    public static void main(String[] args) {
        Person person = new Person("musie", 89, "Male");
        System.out.println(person.getAge());
        person.setAge(10);

        System.out.println(person.getAge());
    }
}
