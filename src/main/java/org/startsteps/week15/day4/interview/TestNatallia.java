package org.startsteps.week15.day4.interview;

public class TestNatallia {

    //2  Write a Java program to compute the distance between two points on the earth's surface.
    // Distance between the two points [(x1,y1) & (x2,y2)]
    // d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
    // Radius of the earth r = 6371.01 Kilometers
    // Input Data:
    // Input the latitude of coordinate 1: 25
    // Input the longitude of coordinate 1: 35
    // Input the latitude of coordinate 2: 35.5
    // Input the longitude of coordinate 2: 25.5
    // Expected Output
    //
    //The distance between those points is: 1480.0848451069087 km

    public static void main2(String[] args) {
        final double radius = 6371.01;
        double x1 = 25;
        double y1 = 35;
        double x2 = 35.5;
        double y2 = 25.5;
        double distance = radius * Math.acos(sin(x1) * sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1-y2));
        System.out.println("distance = " + distance/Math.PI);
    }

    public static double sin(double a){
        return Math.sin(a);
    }






    //5 Write a Java program to add one to a positive number represented as an array of digits.
    //
    //Sample array: [9, 9, 9, 9] which represents 9999
    //Output: [1, 0, 0, 0, 0].
    //
    //Expected Output:
    //
    //Original array: [9, 9, 9, 9]
    //Array of digits: [1, 0, 0, 0, 0]

    public static void main(String[] args) {
        //solution 1
        getNumberFromArray(new int[]{1,2,6,7,8});
        getArrayFromNumber(10006);

        //solution 2
        // without changing the format of the number (no conversion from array to number)

    }

    // 6 -> 126 '+', '*'
    // 6 * 1
    // 2 * 10 + 6 = 26
    // 1 * 100 + 26 = 126


    // 1 -> 12678
    // 1
    // 1 * 10 + 2 = 12
    // 12 * 10 + 6 = 126
    //
    public static int getNumberFromArray(int[] array){
        int result = array[0];
        for(int i=1; i<array.length; i++){
            result = result * 10 + array[i];
        }
        System.out.println(result);
        return result;
    }



    // 12567

    // 7?
    // 12567 % 10 = 1256 (7)
    // 12567 / 10 = 1256 / 10 = 125 / 10 = 12 / 10 = 1 / 10 = 0
    public static int[] getArrayFromNumber(int number){
        int[] array = new int[100];
        int index = 0;
        while(number!=0){
            array[index++] = number % 10;
            number = number / 10;
        }

        int[] result = new int[index];
        for (int i = 0; i < index; i++){
            result[index - i - 1] = array[i];
        }
        for (int a : result) {
            System.out.println(a);
        }
        return result;
    }

}
