package myproject.flightplanner.repository;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.NoAgencyGivenForAirportException;
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

    private static Map<Integer, Airport> airports = new HashMap<>();

    static {
        airports.put(1236, new Airport(1236, "Ferihegy", "Budapest Airs"));
        airports.put(5691, new Airport(5691, "Eiffel", "Paris Inc."));
        airports.put(6370, new Airport(6370, "Meri", "Chinatown AG"));
    }

    public Collection<Airport> getAllAirport(){
        return this.airports.values();
    }

    public Airport getAirportsByName(Integer id){
        return this.airports.get(id);
    }

    public void removeAirportByName(Integer id) {
        this.airports.remove(id);
    }

    public void updateAirport(Airport airport) throws Exception{

            Airport updatedAirport = airports.get(airport.getId());
            updatedAirport.setName(airport.getName());
            updatedAirport.setAgency(airport.getAgency());
            airports.put(airport.getId( ), airport);
    }

    public void createAirport(Airport airport) throws Exception{
        Airport newAirport = new Airport();
        newAirport.setId(airport.getId());
        newAirport.setName(airport.getName());
        newAirport.setAgency(airport.getAgency());
        airports.put(airport.getId(), airport);
    }
}
