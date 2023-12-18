package org.startsteps.week15.day5.interview;

public class Test {
    public static void main(String[] args) {
        String num1 = "125"; //3
        String num2 = "1456"; //4
        String result = "";
        int res;
        int carryOver = 0;
        for (int i = Math.max(num1.length(), num2.length()); i >= 0; i--) {
            int a = num1.toCharArray()[i] - 48;
            int b = num2.toCharArray()[i] - 48;
            int c = a + b + carryOver;
            if(c>=10){
                carryOver = c % 10;
                c = c/10;
            }else{
                carryOver = 0;
            }
            System.out.println("c = " +c);
            System.out.println(carryOver);
        }

//        char a = 'a';
//        char c = 'c';
//        int x = a + c;
    }
}
