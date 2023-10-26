package org.startsteps.week8.class_04;

import java.io.*;
import java.nio.file.*;

public class ExerciseFive {
    public static void main(String[] args) {
        // Create a backup of the serialized data for disaster recovery
        try {
            Path originalFile = Paths.get("student_data.ser");
            Path backupFile = Paths.get("student_data_backup.ser");

            Files.copy(originalFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup created successfully for disaster recovery purposes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}