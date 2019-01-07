package myproject.flightplanner.controller;

import myproject.flightplanner.model.Airport;
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
    public Airport getAirportByName(@PathVariable("id") Integer id) {
        return airportService.getAirportsByName(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeAirportByName(@PathVariable("id") Integer id) {
        airportService.removeAirportByName(id);
    }

    @PutMapping(value = "/update-airport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAirport(@RequestBody Airport airport) throws Exception {
        airportService.updateAirport(airport);
    }

    @PutMapping(value = "/create-airport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAirport(@RequestBody Airport airport) throws Exception {
        airportService.createAirport(airport);
    }
}
