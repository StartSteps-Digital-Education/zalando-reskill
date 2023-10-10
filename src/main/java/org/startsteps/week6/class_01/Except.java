package org.startsteps.week6.class_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Except {
//    Checked exceptions must be either caught or declared,
//    while unchecked exceptions do not require this.
//
//    Custom exception classes by extending Exception or
//    its subclasses to represent application-specific error conditions.
//
//    Use meaningful exception messages to describe the nature of the problem.

//    Avoid catching and ignoring exceptions without a good reason;
//    it may lead to hidden issues.

//    Log exceptions or relevant information for debugging and troubleshooting.
 // log it or throw again
// try {
//
//    } catch(Exception exception) { // ignore - no side effect //
    // finally {
    //   close()
    // } // read a file - file stream opened - closed

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter the name of the file: ");
            String fileName = input.nextLine();

            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error file not found");
        } finally {
            input.close();
        }
    }
}
