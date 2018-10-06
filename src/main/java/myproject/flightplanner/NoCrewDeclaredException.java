package myproject.flightplanner;

class NoCrewDeclaredException extends Exception{
    NoCrewDeclaredException(String message) {
        super(message);
    }
}
