package org.startsteps.week12.class_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactEx {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactdb", "username", "password");
            connection.setAutoCommit(false); // Disable auto-commit mode

            // Insert data into one table
            String insertQuery = "INSERT INTO Courses (CourseName, CourseDescription) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "Java Programming");
            insertStatement.setString(2, "Learn Java programming language");
            insertStatement.executeUpdate();

            // Update data in another table
            String updateQuery = "UPDATE Themes SET ThemeName = ? WHERE ID = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, "Advanced Java");
            updateStatement.setInt(2, 1);
            updateStatement.executeUpdate();

            // Delete data from one table
            String deleteQuery = "DELETE FROM Courses WHERE ID = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, 1);
            deleteStatement.executeUpdate();

            connection.commit(); // Commit the transaction
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback(); // Roll back the transaction
                } catch (SQLException ex2) {
                    System.err.println(ex2.getMessage());
                }
            }
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
