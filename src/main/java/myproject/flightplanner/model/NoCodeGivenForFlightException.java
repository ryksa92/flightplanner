package myproject.flightplanner.model;

public class NoCodeGivenForFlightException extends Exception{
    NoCodeGivenForFlightException(String message) {
        super(message);
    }
}
