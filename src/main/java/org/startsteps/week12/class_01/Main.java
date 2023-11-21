package org.startsteps.week12.class_01;

import org.startsteps.week12.class_01.persistence.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
//1.2
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            if (connection != null) {
                System.out.println("Connection successful!");
                Flights.insertFlight("Airline A", "City X", "City Y", "2023-01-01 08:00:00", "2023-01-01 12:00:00", 300.0, 120);
                Flights.insertFlight("Global Airlines", "Country X Airport", "Country Y Airport", "2023-04-20 22:00:00", "2023-04-21 04:00:00", 500.0, 200);
                Flights.insertFlight("Promo Air", "City C", "City D", "2023-05-10 09:00:00", "2023-05-10 11:00:00", 80.0, 100);
                Flights.selectFlights("Destination", "City Y");
                Flights.updateFlight(1, "Price", "200.00");
                Flights.deleteFlight(1);
                connection.close(); // Close the connection after testing
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
