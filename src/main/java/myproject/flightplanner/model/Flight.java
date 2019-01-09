package myproject.flightplanner.model;

import java.util.HashMap;
import java.util.Map;

public class Flight {

    private String code;
    private String regAirport;
    private Integer numbersOfCrew;
    private Integer numbersOfPassengers;

    private HashMap<String, Person> people = new HashMap<>( );

    public Flight(){};
    public Flight(String code, String regAirport, Integer numbersOfCrew, Integer numbersOfPassengers){
        this.code = code;
        this.regAirport = regAirport;
        this.numbersOfCrew = numbersOfCrew;
        this.numbersOfPassengers = numbersOfPassengers;
    };

    public String getCode() throws NoCodeGivenForFlightException{
        if (code == null){
            throw new NoCodeGivenForFlightException("No code given for Flight! Assign one!");
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegAirport() throws NoRegAirportForFlightException{
        if (regAirport == null) {
            throw new NoRegAirportForFlightException("This Flight is not registered to any Airport.");
        }
        return regAirport;
    }

    public void setRegAirport(String regAirport) {
        this.regAirport = regAirport;
    }

    public void setNumbersOfCrew(Integer numbersOfCrew){
        this.numbersOfCrew = numbersOfCrew;
    }

    public void setNumbersOfPassengers(Integer numbersOfPassengers){
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

    public void printCrew() throws NoCrewDeclaredException, NoJobDeclaredException {
        System.out.print(" -- Crew members: ");

        for (Map.Entry<String, Person> personEntry : people.entrySet( )) {
            if (personEntry.getKey( ).isEmpty( )) {
                throw new NoCrewDeclaredException("No Crew declared");
            }

            if (personEntry.getValue( ).getClass( ).isAssignableFrom(Crew.class)) {
                Crew crew = (Crew) personEntry.getValue( );
                if (crew.getCrewJob( ) == null) {
                    throw new NoJobDeclaredException("No Crew job declared");
                } else {
                    System.out.print(crew.getName( ) + " Job:" + crew.getCrewJob( ) + ", ");
                }
            }

        }
    }

    public void printPassengers() {
        System.out.print(" -- Passengers: ");
        for (Map.Entry<String, Person> personEntry : people.entrySet( )) {
            if (personEntry.getValue( ).getClass( ).isAssignableFrom(Passenger.class)) {
                Passenger passenger = (Passenger) personEntry.getValue( );
                System.out.print(passenger.getName( ) + passenger.getCheckedBagsInKg( ));
            }
        }
    }
}

