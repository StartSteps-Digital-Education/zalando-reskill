package org.startsteps.week2.class_01;

public class Loops {
    //        WriteRectangle(4, 3);

    //        Create a function WriteRectangle to display a (filled)
    //        rectangle on the screen, with the width and height
    //        indicated as parameters, using asterisks.
    //                Complete the test program with a Main function:
    //        WriteRectangle(4,3);
    //        should display
    //    ****
    //    ****
    //    ****

    public static void writeRectangle(int height, int width) {
        if (height > 1 && width > 1) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
