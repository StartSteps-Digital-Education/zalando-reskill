package org.startsteps.week15.day1.interview;

import java.util.Arrays;

public class Test {

    //1. What will this code print?
    public static void main(String[] args) {
        // System.out.println(Math.min(Double.MIN_VALUE, 0.0d));// 0.000...49 0.0
        // System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));// -2^31, 0.0

        int x = 0;
        System.out.println(x);
        x = 50;
        System.out.println(x);
        x = Integer.MAX_VALUE;
        System.out.println(x);
        x++;
        System.out.println(x);
        System.out.println(Integer.MIN_VALUE);
        // Integer.MAX_VALUE + 1 = Integer.MIN_VALUE; is an overflow

        short z = 32767; // -32766 to 32767 is the range
        byte q = 127; // -128 to 127

        // System.out.printf("%d-----%6.2f----- %s",10, 2.4f, "test" );

        String tableFormatTitle = "|%10s|%20s|%4s|%10s|%15s|";
        String tableFormat = "|%10s|%20s|%4d|%10s|%15.3f|";
        // SELECT * FROM User;
        //Name LastName Age Gender Salary
        System.out.println();
        System.out.printf(tableFormatTitle, "Name", "Last Name", "Age", "Gender", "Salary");
        System.out.println();
        System.out.printf("%s","--------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf(tableFormat, "Menil", "Vukovic", 33, "Male", 1000.00d);
        System.out.println();
        System.out.printf(tableFormat, "John", "Doe", 22, "Male", 999.00d);
        System.out.println();
        System.out.printf(tableFormat, "John", "Doe", 22, "Male", 999.00d);
        System.out.println();
        System.out.printf(tableFormat, "John", "Doe", 22, "Male", 999.00d);
        System.out.println();
        System.out.printf(tableFormat, "John", "Doe", 22, "Male", 999.00d);
        System.out.println();
        System.out.printf(tableFormat, "John", "Doe", 22, "Male", 999.00d);
        System.out.println();
        System.out.printf("%s","--------------------------------------------------------------------------------");
        System.out.println();

        vargArgs(10, 20, 40, 50, 50, 90, 100, 100, 100, 200, 200,999);

        String name = "Lena";
        System.out.printf("My name is %s and my salary is %d and I love to go hiking here: %s", name, 10000, "Mount Everest");
    }

    // 0L -> Long
    // 0.0d -> Double
    // 0.0f -> Float

    public static void vargArgs(int... ints){ //varargs
        for (int x : ints) {
            System.out.println(x);
        }
    }
}



















//2
//What will happen if you put the return statement or System.exit() on the 'try' or 'catch' block? Will the 'finally' block execute?

class Test4 {
    public static void main(String[] args) {
        System.out.println(anotherFunction());
    }

    private static int anotherFunction() {
        try{
            // System.exit(0); // this prevents finally from running
            return 2; // finally runs
        } catch (Exception e){
            return 1;
        } finally {
            System.out.println("Will this execute?");
        }
        // return 0;
    }
}
























//4
//What will the expression 1.0 / 0.0 return? Will it throw an exception or any compile-time errors?

// I don't know this answer but...
// 1.0 is a float or a double as is 0.0
// 1 cannot be divided by 0 mathematically because that's not defined
// 5/0 Arithmetic Exception


class Test5 {
    public static void main(String[] args) {
        System.out.println(1.0 / 0.0);
        System.out.println(1.0 / 0.1); // 1/0.1 = 1/ 1/10 = 1/1 / 1/10 = 1* 10/ 1*1 = 10
    }
}

















//5
class Test2 {
    public static void main(String[] args) throws Exception {
        char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}



















//6
class Test3{
    public static void main(String args[])
    {
        String str="12ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5;
        String str2=1+2+"ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5;
        System.out.println(str);
        System.out.println(str2);
        // "12ONE12TWOTHREE34FOURFIVE5"
        // "3ONE12TWOTHREE34FOURFIVE5"
    }
}