package myproject.flightplanner.service;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.NoAgencyGivenForAirportException;
import myproject.flightplanner.model.NoIDGivenForAirportException;
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

    public Airport getAirportsByID(Integer id) {
        return airportRepository.getAirportsByID(id);
    }

    public void removeAirportByID(Integer id) {
        this.airportRepository.removeAirportByID(id);
    }

    public void modifyAirport(Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException {
        this.airportRepository.modifyAirport(airport);
    }

    public void createAirport(Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException {
        this.airportRepository.createAirport(airport);
    }

}
