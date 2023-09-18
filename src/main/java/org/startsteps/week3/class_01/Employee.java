package org.startsteps.week3.class_01;

// subclass (child class)
public class Employee extends Person {
    private String newEmployeeAddress;
    @Override
    public void changeAddress(String newAddress) {
        newEmployeeAddress = newAddress;
    }
}
