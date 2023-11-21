package org.startsteps.week12.class_01;

import org.startsteps.week12.class_01.persistence.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Flights {

    public static void insertFlight(String airline, String origin, String destination, String departureTime, String arrivalTime, double price, int seatsAvailable) throws SQLException {
        String insertSql = "INSERT INTO Flight (" +
                "Airline, " +
                "Origin, " +
                "Destination, " +
                "DepartureTime, " +
                "ArrivalTime, " +
                "Price, " +
                "SeatsAvailable) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, airline);
            preparedStatement.setString(2, origin);
            preparedStatement.setString(3, destination);
            preparedStatement.setString(4, departureTime);
            preparedStatement.setString(5, arrivalTime);
            preparedStatement.setDouble(6, price);
            preparedStatement.setInt(7, seatsAvailable);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Flight inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insertion failed.");
        }
    }

    public static void selectFlights(String criteria, String value) {
        String query = "SELECT * FROM Flight WHERE " + criteria + " = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Assuming you have columns as specified earlier
                System.out.println("Flight ID: " + resultSet.getInt("FlightID") + ", Airline: " + resultSet.getString("Airline") + ", ..."); // Continue for other columns
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed.");
        }
    }

    public static void updateFlight(int flightID, String column, String newValue) {
        String updateSql = "UPDATE Flight SET " + column + " = ? WHERE FlightID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, flightID);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Flight updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update failed.");
        }
    }

    public static void deleteFlight(int flightID) {
        String deleteSql = "DELETE FROM Flight WHERE FlightID = ?";
        //deleteBookingsByFlight(flightID);

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setInt(1, flightID);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Flight deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete failed.");
        }
    }
    public static void deleteBookingsByFlight(int flightID) {
        String sql = "DELETE FROM Booking WHERE FlightID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, flightID);
            preparedStatement.executeUpdate();
            System.out.println("Bookings for FlightID " + flightID + " deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete bookings failed.");
        }
    }

//    ALTER TABLE Booking
//    DROP FOREIGN KEY booking_ibfk_2;
//
//    ALTER TABLE Booking
//    ADD CONSTRAINT booking_ibfk_2
//    FOREIGN KEY (FlightID) REFERENCES Flight(FlightID)
//    ON DELETE CASCADE;

}