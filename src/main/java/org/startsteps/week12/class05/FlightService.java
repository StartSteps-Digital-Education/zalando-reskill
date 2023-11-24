package org.startsteps.week12.class05;

import org.startsteps.week12.class_01.persistence.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightService {

    public static void bookFlight(int customerId, int flightId, int numberOfPassengers) {
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);

//          checkForAvailableSeats(flightId, numberOfPassengers, connection);
            insertNewBooking(customerId, flightId, numberOfPassengers, connection);
            updateSeatsOfTheFlight(flightId, numberOfPassengers, connection);

            connection.commit();
            System.out.println("Flight booked successfully");
        } catch (SQLException e) {
            // Rollback transaction if exception occurs
            DatabaseUtil.checkAndRollback(connection);
            e.printStackTrace();
        } finally {
            DatabaseUtil.checkAndClose(connection);
        }
    }

    private static void updateSeatsOfTheFlight(int flightId, int numberOfPassengers, Connection connection) throws SQLException {
        // Update SeatsAvailable in the Flight table
        String updateFlightSql = "UPDATE Flight SET SeatsAvailable = SeatsAvailable - ? WHERE FlightID = ? AND SeatsAvailable - ? > 0";
        try (PreparedStatement flightStmt = connection.prepareStatement(updateFlightSql)) {
            flightStmt.setInt(1, numberOfPassengers);
            flightStmt.setInt(2, flightId);
            flightStmt.setInt(3, numberOfPassengers);
            int affectedRows = flightStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating flight failed, no rows affected.");
            }
        }
    }

    private static void insertNewBooking(int customerId, int flightId, int numberOfPassengers, Connection connection) throws SQLException {
        // Insert a record in the Booking table
        String insertBookingSql = "INSERT INTO Booking (CustomerID, FlightID, NumberOfPassengers, Status, BookingDate) VALUES (?, ?, ?, 'Confirmed', NOW())";
        try (PreparedStatement bookingStmt = connection.prepareStatement(insertBookingSql)) {
            bookingStmt.setInt(1, customerId);
            bookingStmt.setInt(2, flightId);
            bookingStmt.setInt(3, numberOfPassengers);
            bookingStmt.executeUpdate();
        }
    }

    private static void checkForAvailableSeats(int flightId, int numberOfPassengers, Connection connection) throws SQLException {
        // Check for SeatsAvailable
        String checkValidSeats = "SELECT SeatsAvailable FROM Flight WHERE FlightID = ?";
        try (PreparedStatement flightStmt = connection.prepareStatement(checkValidSeats)) {
            flightStmt.setInt(1, flightId);
            ResultSet validSeats = flightStmt.executeQuery();

            if (validSeats.next())
                if (validSeats.getInt("SeatsAvailable") - numberOfPassengers < 0){
                    throw new SQLException("Updating flight failed, not enough seats on the flight.");
                }
        }
    }

    public static void printAvailableSeats(int flightId) {
        String query = "SELECT SeatsAvailable FROM Flight WHERE FlightID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int seatsAvailable = resultSet.getInt("SeatsAvailable");
                System.out.println("Flight ID " + flightId + " has " + seatsAvailable + " seats available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve available seats.");
        }
    }
}
