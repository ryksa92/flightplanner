package myproject.flightplanner.controller;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.NoNameGivenForAirportException;
import myproject.flightplanner.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @GetMapping(value = "/{name}")
    public Airport getAirportByName(@PathVariable("name") String name) {
        return airportService.getAirportByName(name);
    }

    @DeleteMapping(value = "/{name}")
    public void removeAirportByID(@PathVariable("name") String name) {
        airportService.removeAirportByName(name);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createAirport(@Valid @RequestBody Airport airport, BindingResult bindingResult) throws NoNameGivenForAirportException{

        if (bindingResult.hasErrors()){
            return "Invalid length of [name], minimum 4 characters.";
        }
        else airportService.createAirport(airport);
        return null;
    }

    @PutMapping(value = "/modify/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modifyAirport(@RequestBody Airport airport, @PathVariable String name) throws NoNameGivenForAirportException{
        airportService.modifyAirport(airport, name);
    }
}
