package myproject.flightplanner.model;

public class NoFlightRegisteredException extends Throwable {
    public NoFlightRegisteredException(String message) {
        super(message);
    }
}
