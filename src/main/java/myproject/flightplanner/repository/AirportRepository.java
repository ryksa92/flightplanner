package myproject.flightplanner.repository;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoNameGivenForAirportException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AirportRepository {

    private static Map<String, Airport> airports = new HashMap<>( );

    public static Map<String, Airport> getAirports() {
        return airports;
    }
    public static void setAirports(Map<String, Airport> airports) {
        AirportRepository.airports = airports;
    }

    static {
        airports.put("Name", new Airport("Name"));
    }


    public Collection<Airport> getAllAirport() {
        return airports.values( );
    }

    public Airport getAirportByName(String name) {
        return airports.get(name);
    }
/*
    public void getAirportFlights(String name) throws NoCodeGivenForFlightException {

        for (Map.Entry<String, Airport> airportEntry : airports.entrySet( )) {
            if (airportEntry.getKey().matches(name)) {
                airportEntry.getValue().printAirportFlights();
            }
            if (airportEntry.getKey().isEmpty( )) {
                throw new NoCodeGivenForFlightException("No flights declared.");
            }
        }
    }
*/
    public void removeAirportByName(String name) {
        airports.remove(name);
    }

    public void createAirport(Airport airport) throws NoNameGivenForAirportException{
        Airport newAirport = new Airport( );
        newAirport.setName(airport.getName());
        airports.put(airport.getName( ), airport);
    }

    public void modifyAirport(Airport airport, String name) throws NoNameGivenForAirportException{

        Airport updatedAirport = airports.get(name);
        updatedAirport.setName(airport.getName());
    }

}
