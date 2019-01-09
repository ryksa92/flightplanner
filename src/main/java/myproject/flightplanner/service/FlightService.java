package myproject.flightplanner.service;

import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoRegAirportForFlightException;
import myproject.flightplanner.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Collection<Flight> getAllFlight() {
        return flightRepository.getAllFlight( );
    }

    public Flight getFlightByCode(String code) {
        return flightRepository.getFlightByCode(code);
    }

    public Flight getFlightByAirport(String regAirport) {
        return flightRepository.getFlightByAirport(regAirport);
    }

    public void removeFlightByCode(String code) {
        this.flightRepository.removeFlightByCode(code);
    }

    public void modifyFlight(Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException{
        this.flightRepository.modifyFlight(flight);
    }

    public void createFlight(Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException{
        this.flightRepository.createFlight(flight);
    }
}
