package myproject.flightplanner.controller;

import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import myproject.flightplanner.model.NoRegAirportForFlightException;
import myproject.flightplanner.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public Collection<Flight> getAllFlight() {
        return flightService.getAllFlight( );
    }

    @GetMapping(value = "/{code}")
    public Flight getFlightByCode(@PathVariable("code") String code) {
        return flightService.getFlightByCode(code);
    }

    @GetMapping(value = "/{regAirport}")
    public Flight getFlightByAirport(@PathVariable("regAirport") String regAirport) {
        return flightService.getFlightByAirport(regAirport);
    }

    @DeleteMapping(value = "/{code}")
    public void removeFlightByCode(@PathVariable("code") String code) {
        flightService.removeFlightByCode(code);
    }

    @PutMapping(value = "/modify", consumes = APPLICATION_JSON_VALUE)
    public void modifyFlight(@RequestBody Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException{
        flightService.modifyFlight(flight);
    }

    @PutMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public void createFlight(@RequestBody Flight flight) throws NoCodeGivenForFlightException, NoRegAirportForFlightException{
        flightService.createFlight(flight);
    }
}
