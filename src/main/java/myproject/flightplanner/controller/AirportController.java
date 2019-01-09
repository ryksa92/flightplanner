package myproject.flightplanner.controller;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.NoAgencyGivenForAirportException;
import myproject.flightplanner.model.NoIDGivenForAirportException;
import myproject.flightplanner.model.NoNameGivenForAirportException;
import myproject.flightplanner.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public Collection<Airport> getAllAirport() {
        return airportService.getAllAirport( );
    }

    @GetMapping(value = "/{id}")
    public Airport getAirportByID(@PathVariable("id") Integer id) {
        return airportService.getAirportsByID(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeAirportByID(@PathVariable("id") Integer id) {
        airportService.removeAirportByID(id);
    }

    @PutMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAirport(@RequestBody Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException{
        airportService.modifyAirport(airport);
    }

    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAirport(@RequestBody Airport airport) throws NoIDGivenForAirportException, NoNameGivenForAirportException, NoAgencyGivenForAirportException {
        airportService.createAirport(airport);
    }
}
