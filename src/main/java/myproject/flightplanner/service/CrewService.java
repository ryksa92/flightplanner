package myproject.flightplanner.service;

import myproject.flightplanner.model.Crew;
import myproject.flightplanner.model.Person;
import myproject.flightplanner.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collection;

@Service
public class CrewService {

    @Autowired
    private CrewRepository crewRepository;

    public Collection<Crew> getAllCrewMembers() {
        return crewRepository.getAllCrewMembers( );
    }

    public Person getCrewMemberByName(String name) {
        return crewRepository.getCrewMemberByName(name);
    }

    public void newCrewMember(@Valid Crew crew) {
        this.crewRepository.newCrewMember(crew);
    }
}
