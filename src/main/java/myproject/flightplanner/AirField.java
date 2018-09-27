package myproject.flightplanner;

import java.util.HashMap;
import java.util.Map;

public class AirField{

    private String name;

    private Map<String, Flight> flights = new HashMap<>( );

    public Map<String, Flight> getFlights() {
        return flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getCode( ), flight);
    }

    public void printFlights() {
        System.out.println( );
        System.out.println("[Airport : " + name + "]");
        System.out.print(" - Flights: ");
        for (Map.Entry<String, Flight> flight : flights.entrySet( )) {
            System.out.print(flight.getKey( ) + ",");
        }
    }

    public boolean isFlightsEmpty () {
        return flights.isEmpty();
    }
}