package myproject.flightplanner.repository;

import myproject.flightplanner.model.Crew;
import myproject.flightplanner.model.CrewJob;
import myproject.flightplanner.model.Person;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CrewRepository {

    private static Map<String, Crew> crewMembers = new HashMap<>();

    public static Map<String, Crew> getCrewMembers() {
        return crewMembers;
    }

    public static void setCrewMembers(Map<String, Crew> crewMembers) {
        CrewRepository.crewMembers = crewMembers;
    }

    static {
        crewMembers.put("Zoltan", new Crew("Zoltan", CrewJob.MECHANIC));
    }

    public Collection<Crew> getAllCrewMembers(){
        return crewMembers.values();
    }

    public Person getCrewMemberByName (String name){
        return crewMembers.get(name);
    }

    public void newCrewMember(@Valid Crew crew) {
        Crew newCrew = new Crew();
        newCrew.setName(crew.getName());
        newCrew.setCrewJob(crew.getCrewJob());
    }
}
