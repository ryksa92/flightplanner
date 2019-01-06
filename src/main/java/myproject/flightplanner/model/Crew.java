package myproject.flightplanner.model;

public class Crew extends Person {

    private CrewJob crewJob;

    public CrewJob getCrewJob() {
        return crewJob;
    }

    public void setCrewJob(CrewJob crewJob) {
        this.crewJob = crewJob;
    }
}

