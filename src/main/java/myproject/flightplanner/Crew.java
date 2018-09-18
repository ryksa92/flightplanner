package myproject.flightplanner;

public class Crew extends Person {

    private CrewJob crewJob;

    public CrewJob getCrewJob() {
        return crewJob;
    }

    public void setCrewJob(CrewJob crewJob) {
        this.crewJob = crewJob;
    }
}

