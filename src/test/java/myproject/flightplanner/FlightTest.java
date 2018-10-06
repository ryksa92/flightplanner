package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class FlightTest {

    @Test
    public void PassengersOnFlightByDefault(){
        Flight flight = new Flight();

        assertEquals("There are already Passengers in Flight!", 0, flight.getNumbersOfPassengers());
    }

    @Test
    public void CrewMembersOnFlightByDefault(){
        Flight flight = new Flight();

        assertEquals("There are already Crew members in Flight!", 0, flight.getNumbersOfCrew());
    }

    @Test
    public void FlightHasNoCodeToAssignToFlight(){
        Flight flight = new Flight();

        assertEquals(null, flight.getCode());
    }
}
