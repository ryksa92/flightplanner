package myproject.flightplanner.service;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoFlightRegisteredException;
import myproject.flightplanner.model.NoNameGivenForAirportException;
import myproject.flightplanner.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Collection<Airport> getAllAirport() {
        return airportRepository.getAllAirport( );
    }

    public Airport getAirportByName(String name) {
        return airportRepository.getAirportByName(name);
    }

    public void removeAirportByName(String name) {
        this.airportRepository.removeAirportByName(name);
    }

    public void createAirport(Airport airport) throws NoNameGivenForAirportException{
        this.airportRepository.createAirport(airport);
    }
    public void modifyAirport(Airport airport, String name) throws NoNameGivenForAirportException {
        this.airportRepository.modifyAirport(airport, name);
    }


/*    public Flight getAirportFlights(String name) throws NoFlightRegisteredException, NoCodeGivenForFlightException{
       return airportRepository.getAirportFlights(name);
    }
*/}
