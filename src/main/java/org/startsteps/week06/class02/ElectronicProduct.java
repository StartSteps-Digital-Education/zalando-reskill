package org.startsteps.week06.class02;

public class ElectronicProduct extends Product {
    private String brand;

    public ElectronicProduct(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }



}
