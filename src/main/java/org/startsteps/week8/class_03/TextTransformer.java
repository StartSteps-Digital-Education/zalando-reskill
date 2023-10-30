package org.startsteps.week8.class_03;

import java.io.*;
import java.util.Locale;

public class TextTransformer {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {

            reader.lines()
                    .map(line -> line.toUpperCase().replace("JAVA", "Python"))
                    .forEach(writer::println);

            System.out.println("Text file transformation done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
