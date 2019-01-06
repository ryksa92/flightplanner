package myproject.flightplanner.model;

public enum CrewJob {
    PILOT ("Pilot"),
    COPILOT ("Co-pilot"),
    MECHANIC ("Mechanic"),
    FLIGHT_ATTENDANT ("Flight attendant");

    private String crewJobClass;

    CrewJob(String crewJobClass) {
        this.crewJobClass = crewJobClass;
    }
}
