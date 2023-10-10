package org.startsteps.week5.class_01.jarLab;

public class MainApp {
   public static void main(String[] args) {
     Calculator calc = new Calculator();
     int result = calc.add(10, 5);
     System.out.println("Result: " + result);
   }
}
