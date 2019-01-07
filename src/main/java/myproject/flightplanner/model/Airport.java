package myproject.flightplanner.model;

import java.util.HashMap;
import java.util.Map;

public class Airport {

    private Integer id;
    private String name;
    private String agency;

    private Map<String, Flight> flights = new HashMap<>();

    public Integer getId() throws NoIDGivenForAirportException{
        if (id.toString().length() < 4 || id.toString().isEmpty()){
            throw new NoIDGivenForAirportException("The given ID is too short for an Airport!");
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgency() throws NoAgencyGivenForAirportException {
        if (agency.isEmpty()){
            throw new NoAgencyGivenForAirportException("No agency defined for the Airport!");
        }
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setFlights(Map<String, Flight> flights) {
        this.flights = flights;
    }

    public Airport(){

    }
    public Airport(Integer id, String name, String agency){
        this.id = id;
        this.name = name;
        this.agency = agency;
    }

    public String getName() throws NoNameGivenForAirportException {
        if (name == null || name.isEmpty( )) {
            throw new NoNameGivenForAirportException("No name airfield");
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

    private String printFlightsList() throws NoCodeGivenForFlightException {
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
