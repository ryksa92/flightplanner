package myproject.flightplanner.model;

public class NoAgencyGivenForAirportException extends Exception {

    NoAgencyGivenForAirportException (String message){
        super(message);
    }
}
