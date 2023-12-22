package org.startsteps.week16.day4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestHoney {
    // Write a Java program to print:
    // yyyy-MM-dd
    // HH:mm:ss
    // yyyy-MM-dd HH:mm:ss
    // E MMM yyyy HH:mm:ss.SSSZ
    // HH:mm:ss,Z
    // format pattern for date and time.


    public static void main(String[] args) {
        Date dateToFormat = new Date();
        // yyyy-MM-dd: 2023-12-21
        datetoFirstFormat(dateToFormat);
        datetoSecondFormat(dateToFormat);
        datetoThirdFormat(dateToFormat);
        datetoFourFormat(dateToFormat);
        datetoFiveFormat(dateToFormat);

        long time = dateToFormat.getTime();
//        System.out.println(time);

        Date date = new Date(2023 - 1900, Calendar.DECEMBER, 31);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        datetoFirstFormat(date);

//        LocalDate date;
//        LocalDateTime dateTime;
//        LocalTime time;
//        TimeZone tz;

    }

    public static void datetoFirstFormat(Date datetoFormat){
        String dateOne = datetoFormat.toString();
        System.out.println(dateOne);
        //Thu Dec 21 14:32:19 CET 2023
        //2023-12-21
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(datetoFormat));


    }

    public static void datetoSecondFormat(Date datetoFormat){
        // HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(datetoFormat));
    }


    public static void datetoThirdFormat(Date datetoFormat){
        // yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(datetoFormat));
    }


    public static void datetoFourFormat(Date datetoFormat){

        // E MMM yyyy HH:mm:ss.SSSZ
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM yyyy HH:mm:ss.SSSZ");
        System.out.println(sdf.format(datetoFormat));
    }


    public static void datetoFiveFormat(Date datetoFormat){

        // HH:mm:ss,Z
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss,Z");
        System.out.println(sdf.format(datetoFormat));
    }



}
