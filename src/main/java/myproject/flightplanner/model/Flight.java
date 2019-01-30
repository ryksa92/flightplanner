package myproject.flightplanner.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Flight {

    @NotNull
    @Size(min = 4)
    private String code = null;

    @NotNull
    @Size(min = 4)
    private String regAirport = null;
    private int numbersOfCrew = 0;
    private int numbersOfPassengers = 0;

    private HashMap<String, Person> people = new HashMap<>( );

    public Flight() {
    }

    public Flight(String code, String regAirport, int numbersOfCrew, int numbersOfPassengers) {
        this.code = code;
        this.regAirport = regAirport;
        this.numbersOfCrew = numbersOfCrew;
        this.numbersOfPassengers = numbersOfPassengers;
    }

    public String getCode() throws NoCodeGivenForFlightException {
        if (code == null) {
            throw new NoCodeGivenForFlightException("No code given for Flight! Assign one!");
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegAirport() throws NoRegAirportForFlightException {
        if (regAirport == null) {
            throw new NoRegAirportForFlightException("This Flight is not registered to any Airport.");
        }
        return regAirport;
    }

    public void setRegAirport(String regAirport) {
        this.regAirport = regAirport;
    }

    public void setNumbersOfCrew(int numbersOfCrew) {
        this.numbersOfCrew = numbersOfCrew;
    }

    public void setNumbersOfPassengers(int numbersOfPassengers) {
        this.numbersOfPassengers = numbersOfPassengers;
    }

    public void addPeople(Person person) throws NoNameGivenForPersonException {
        if (person.getName( ) == null) {
            throw new NoNameGivenForPersonException("No name given for this person.");
        }
        people.put(person.getName( ), person);
    }

    public int getNumbersOfCrew() {
        int sizeOfCrew = 0;
        for (Map.Entry<String, Person> personEntry : people.entrySet( )) {
            if (personEntry.getValue( ).getClass( ).isAssignableFrom(Crew.class)) {
                sizeOfCrew++;
            }
        }
        return sizeOfCrew;
    }

    public int getNumbersOfPassengers() {
        int sizeOfPassenger = 0;
        for (Map.Entry<String, Person> personEntry : people.entrySet( )) {
            if (personEntry.getValue( ).getClass( ).isAssignableFrom(Passenger.class)) {
                sizeOfPassenger++;
            }
        }
        return sizeOfPassenger;
    }
}
