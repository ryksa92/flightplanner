package myproject.flightplanner.model;

public class NoIDGivenForAirportException extends Exception {
    NoIDGivenForAirportException(String message){
        super(message);
    }
}
