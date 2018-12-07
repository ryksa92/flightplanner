package myproject.flightplanner.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MainController {

    private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());

    @RequestMapping("/")
    public String index() {
        LOGGER.info("FlightPlanner Server Introduction.");
        return "Greetings from SpringBoot";
    }

    @RequestMapping("/list-airfields")
    public String listAirfields() {
        LOGGER.info("Airfield list created.");
        return "Airfield list:";
    }

    @PostMapping(path = "/add-airfield")
    public void addAirfield(@RequestBody String requestBody) {
        LOGGER.info(requestBody);
    }

}