package myproject.flightplanner.repository;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoAgencyGivenForAirportException;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoIDGivenForAirportException;
import myproject.flightplanner.model.NoNameGivenForAirportException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AirportRepository {

    private static Map<Integer, Airport> airports = new HashMap<>( );

    static {
        airports.put(9999, new Airport(9999, "Sample", "Sample Airs"));
    }

    public Collection<Airport> getAllAirport() {
        return airports.values( );
    }

    public Airport getAirportsByID(Integer id) {
        return airports.get(id);
    }

    public void removeAirportByID(Integer id) {
        airports.remove(id);
    }

    public void modifyAirport(Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException {

        Airport updatedAirport = airports.get(airport.getId( ));
        updatedAirport.setName(airport.getName( ));
        updatedAirport.setAgency(airport.getAgency( ));
        airports.put(airport.getId( ), airport);
    }

    public void createAirport(Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException {
        Airport newAirport = new Airport( );
        newAirport.setId(airport.getId( ));
        newAirport.setName(airport.getName( ));
        newAirport.setAgency(airport.getAgency( ));
        airports.put(airport.getId( ), airport);
    }
}
