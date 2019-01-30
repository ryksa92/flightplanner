package myproject.flightplanner.controller;

import myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.Crew;
import myproject.flightplanner.model.Person;
import myproject.flightplanner.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @GetMapping
    public Collection<Crew> getAllCrewMembers(){
        return crewService.getAllCrewMembers();
    }

    @GetMapping(value = "/{name}")
    public Person getCrewMemberByName(@PathVariable("name") String name) {
        return crewService.getCrewMemberByName(name);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newCrewMember (@Valid @RequestBody Crew crew, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "Invalid input.";
        }
        else crewService.newCrewMember(crew);
        return null;
    }
}
