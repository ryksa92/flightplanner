package myproject.flightplanner;

import org.junit.Assert;
import org.junit.Test;

public class FlightTest {

    @Test
    public void testCorrectNumberOfOfCrew() throws NoNameGivenForPersonException {
        Flight flight = new Flight();

        Crew crew1 = new Crew();
        crew1.setName("Józsi");
        flight.addPeople(crew1);

        Crew crew2 = new Crew();
        crew2.setName("Pista");
        flight.addPeople(crew2);

        Passenger passenger1 = new Passenger();
        passenger1.setName("Lófasz");
        flight.addPeople(passenger1);

        Assert.assertEquals(2, flight.getNumbersOfCrew());
    }

    @Test(expected = NoNameGivenForPersonException.class)
    public void testNoNameCrew() throws NoNameGivenForPersonException {
        Flight flight = new Flight();
        flight.addPeople(new Crew());
    }
}