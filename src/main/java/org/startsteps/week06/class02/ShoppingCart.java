package org.startsteps.week06.class02;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends Product> {
   private List<T> products;

   public ShoppingCart() {
       products = new ArrayList<>();
   }

   public void addProduct(T product) {
       products.add(product);
   }

   List<T> getProducts() {
       return products;
   }
}
