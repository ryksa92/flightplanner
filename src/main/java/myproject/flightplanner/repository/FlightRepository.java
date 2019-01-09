package myproject.flightplanner.repository;

import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoRegAirportForFlightException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FlightRepository {

    private static Map<String, Flight> flights = new HashMap<>( );

    static {
        flights.put("AD1000", new Flight("AD1000","BPAirlines",0,0));
    }

    public Collection<Flight> getAllFlight() {
        return flights.values( );
    }

    public Flight getFlightByCode(String code) {
        return flights.get(code);
    }

    public Flight getFlightByAirport(String regAirport) {
        return flights.get(regAirport);
    }

    public void removeFlightByCode(String code) {
        flights.remove(code);
    }

    public void modifyFlight(Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException {
        Flight updatedFlight = flights.get(flight.getCode( ));
        updatedFlight.setCode(flight.getCode( ));
        updatedFlight.setRegAirport(flight.getRegAirport());
        updatedFlight.setNumbersOfCrew(flight.getNumbersOfCrew());
        updatedFlight.setNumbersOfPassengers(flight.getNumbersOfPassengers());
        flights.put(flight.getCode( ), flight);
    }

    public void createFlight(Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException {
        Flight newFlight = new Flight( );
        newFlight.setCode(flight.getCode( ));
        newFlight.setRegAirport(flight.getRegAirport());
        newFlight.setNumbersOfCrew(flight.getNumbersOfCrew());
        newFlight.setNumbersOfPassengers(flight.getNumbersOfPassengers());
        flights.put(flight.getCode( ), flight);
    }
}
