package myproject.flightplanner.model;

class NoCrewDeclaredException extends Exception{
    NoCrewDeclaredException(String message) {
        super(message);
    }
}
