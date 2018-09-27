package myproject.flightplanner;

public enum CrewJob {
    PILOT ("Pilot"),
    COPILOT ("Co-pilot"),
    MECHANIC ("Mechanic"),
    FLIGHT_ATTENDANT ("Flight attendant");

    private String crewJob;

    CrewJob(String crewJob){
        this.crewJob = crewJob;
    }
}
