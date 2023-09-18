package org.startsteps.week3.class_01;
import java.util.Objects;

public class Product {
    private int id;
    private String name;

    public Product (int id, String name){
       this.id=id;
       this.name=name;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj instanceof Product){
            boolean isNameEqual = ((Product) obj).name.equals(this.name);
            boolean isIdEqual = ((Product) obj).id==this.id;
            return isNameEqual&&isIdEqual;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name;
    }

    public static void main(String[] args) {
        Product product1 = new Product (1234, "Product One");
        Product product2 = new Product (1234, "Product Two");
        Product product3 = new Product (1234, "Product One");
        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());
        System.out.println(product3.hashCode());
        System.out.println(product1.equals(product2));
        System.out.println(product1.equals(product3));
        System.out.println(product2.equals(product3));
        System.out.println(product1.toString());
    }
}
