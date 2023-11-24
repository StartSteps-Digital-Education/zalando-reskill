package org.startsteps.week12.class05;

public class Main {

    public static void main(String[] args) {

        // Task 1:

        // Successful Booking test
        System.out.println("Test 1: Successful Booking");
        // Parameters: valid customer ID, valid flight ID, and an acceptable number of passengers
        FlightService.bookFlight(1, 9, 2);

        // Booking with invalid Flight ID test
        System.out.println("\nTest 2: Booking with Invalid Flight ID");
        // Parameters: valid customer ID, invalid flight ID, and number of passengers
        FlightService.bookFlight(1, 999, 2);

        // Booking exceeding available seats test
        System.out.println("\nTest 3: Booking Exceeding Available Seats");
        // Parameters: valid customer ID, valid flight ID, and excessive number of passengers
        FlightService.bookFlight(1, 13, 98);


        // Task 2:

        int testCustomerId = 1;
        int testFlightId = 2;
        int numberOfPassengers = 3;

        System.out.println("Testing Successful Booking Scenario");

        // Before Booking: Print available seats
        System.out.println("Available Seats before Booking:");
        FlightService.printAvailableSeats(testFlightId);

        // Attempt booking
        FlightService.bookFlight(testCustomerId, testFlightId, numberOfPassengers);

        // After Booking: Print available seats
        System.out.println("Available Seats after Booking:");
        FlightService.printAvailableSeats(testFlightId);
    }
}

