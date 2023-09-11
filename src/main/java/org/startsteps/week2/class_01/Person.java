package org.startsteps.week2.class_01;

public class Person {
    private String name;
    private int age = 10;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

//    public Person(String name, int age, String gender) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//    }


    // setter method
    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setGender(String gender) {
        this.gender = gender;
    }


    // getter method
    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    String getGender() {
        return this.gender;
    }

    // data is initialized - attributes
    // methods - take an action
    // represent a real life object

    public static void main(String[] args) {
        Person person = new Person("musie", 89, "Male");
        // set - setters

        // get - getters
//        System.out.println(person.());
        Person person1 = new Person("musie", "Male");
//        person.name = "Julia";
//        System.out.println(person.name);
    }
}
