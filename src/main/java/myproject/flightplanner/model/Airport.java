package myproject.flightplanner.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airport {

    private String name;
    private String description;
    private String agency;

    private Map<String, Flight> flights = new HashMap<>( );
    public Map<String, Flight> getFlights() {
        return flights;
    }

    public Airport(){ }

    public Airport(String name, String description, String agency){
        this.name = name;
        this.description = description;
        this.agency = agency;
    }

    public String getName() throws NoNameGivenForAirfieldException {
        if (name == null || name.isEmpty( )) {
            throw new NoNameGivenForAirfieldException("No name airfield");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight) throws NoCodeGivenForFlightException {
        if (flight.getCode( ) == null || flight.getCode( ).isEmpty( )) {
            throw new NoCodeGivenForFlightException("No code given for Flight");
        }
        flights.put(flight.getCode( ), flight);
    }

    public void printFlights() throws NoCodeGivenForFlightException {
        if (flights.isEmpty( )) {
            throw new NoCodeGivenForFlightException("No flights declared.");
        }

        System.out.println( );
        System.out.println("[Airport : " + name + "]");
        System.out.print(" - Flights: ");
        for (Map.Entry<String, Flight> flight : flights.entrySet( )) {
            System.out.print(flight.getKey( ) + ",");
        }
    }

    public String printFlightsList() throws NoCodeGivenForFlightException {
        if (flights.isEmpty( )) {
            throw new NoCodeGivenForFlightException("No flights declared.");
        }
        for (Map.Entry<String, Flight> flight : flights.entrySet( )) {
            System.out.println(flight.getKey( ));
        }
        return printFlightsList( );
    }

    public boolean isFlightsEmpty() {
        return flights.isEmpty( );
    }
}
