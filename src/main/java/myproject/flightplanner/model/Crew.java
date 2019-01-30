package myproject.flightplanner.model;

import java.util.HashMap;
import java.util.Map;

public class Crew extends Person {

    private CrewJob crewJob;

    public void setCrewJob(CrewJob crewJob) {
        this.crewJob = crewJob;
    }

    public Crew(){
    }

    public Crew (String name, CrewJob crewJob){
        super(name);
        this.crewJob = crewJob;
    }

    public CrewJob getCrewJob() {
        return crewJob;
    }
}

