package org.startsteps.week8.class_03;

public class User {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;

    public User(String name, int age, String email, String phone, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}