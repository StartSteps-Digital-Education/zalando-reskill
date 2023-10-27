package org.startsteps.week8.class_01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List newList = new ArrayList<Integer>(); // elements?
    // initial capacity 10

    public static void main(String[] args) {
        System.out.println("Hello!");
        // Note: all exercises can


        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                //my own writing logic
            }
        };



        MenilsOutputsStream mos = new MenilsOutputsStream();

        MenilsOutputStream menilsOutputStream = new MenilsOutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(9);
    }
}

interface MenilsOutputStream {
    void write(int b) throws IOException;
}