package myproject.flightplanner.service;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Collection<Airport> getAllAirport(){
        return airportRepository.getAllAirport();
    }

    public Airport getAirportsByName(Integer id){
        return airportRepository.getAirportsByName(id);
    }

    public void removeAirportByName(Integer id){
        this.airportRepository.removeAirportByName(id);
    }

    public void updateAirport(Airport airport) throws Exception{
        this.airportRepository.updateAirport(airport);
    }

    public void createAirport(Airport airport) throws Exception{
        this.airportRepository.createAirport(airport);
    }
}
