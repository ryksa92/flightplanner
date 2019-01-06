package myproject.flightplanner;
/*
import myproject.flightplanner.model.Crew;
import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoNameGivenForPersonException;
import myproject.flightplanner.model.Passenger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FlightTest {

    @Test
    public void AssignPassengerToFlightWithName() throws NoNameGivenForPersonException {
        Flight flight = new Flight( );
        Passenger passenger = new Passenger();
        passenger.setName("Józsi");
        flight.addPeople(passenger);

        assertEquals("Passengers can't be registered to Flight", 1, flight.getNumbersOfPassengers( ));

        assertEquals("Passengers didn't get the name", "Józsi", passenger.getName());
    }

    @Test (expected = NoNameGivenForPersonException.class)
    public void AssignPassengerToFlightWithoutName() throws NoNameGivenForPersonException {
        Flight flight = new Flight( );
        Passenger passenger = new Passenger();
        flight.addPeople(passenger);

        assertEquals(1, flight.getNumbersOfPassengers( ));
    }

    @Test
    public void AssignCrewToFlightWithName() throws NoNameGivenForPersonException {
        Flight flight = new Flight( );
        Crew crew = new Crew();
        crew.setName("John");
        flight.addPeople(crew);

        assertEquals(1, flight.getNumbersOfCrew( ));
        assertEquals("John", crew.getName());
    }

    @Test (expected = NoNameGivenForPersonException.class)
    public void AssignCrewToFlightWithoutName() throws NoNameGivenForPersonException {
        Flight flight = new Flight( );
        Crew crew = new Crew();
        flight.addPeople(crew);

        assertEquals(1, flight.getNumbersOfCrew( ));
    }
}
*/