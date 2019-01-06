package myproject.flightplanner;
/*ort myproject.flightplanner.model.Airport;
import myproject.flightplanner.model.Flight;
import myproject.flightplanner.model.NoCodeGivenForFlightException;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class AirportTest {

    @Test (expected = NoCodeGivenForFlightException.class)
    public void CheckAirfieldIsEmptyOfFlights_NoCode() throws NoCodeGivenForFlightException{
        Airport airfield = new Airport( );

        Flight flight = new Flight();
        airfield.addFlight(flight);

        assertEquals("Airfield is empty (without Flights)!", false, airfield.isFlightsEmpty());
    }

    @Test
    public void CheckAirfieldIsEmptyOfFlights_WithCode() throws NoCodeGivenForFlightException{
        Airport airfield = new Airport( );
        airfield.setName("PC");

        Flight flight1 = new Flight();
        flight1.setCode("AVC");

        airfield.addFlight(flight1);

        assertEquals("", false, airfield.isFlightsEmpty());
    }

    @Test (expected = NoCodeGivenForFlightException.class)
    public void MultipleAirfieldWithAssignedFlightsTest_NoCode() throws NoCodeGivenForFlightException{
        Airport airfield = new Airport( );
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();

        airfield.addFlight(flight1);
        airfield.addFlight(flight2);

        assertEquals("Adding Flights to Airfield failed!", false, airfield.isFlightsEmpty());
    }

    @Test (expected = NoCodeGivenForFlightException.class)
    public void MultipleAirfieldWithAssignedFlightsTest_WithCode() throws NoCodeGivenForFlightException{
        Airport airfield1 = new Airport( );
        Flight flight1 = new Flight();
        Airport airfield2 = new Airport( );
        Flight flight2 = new Flight();

        airfield1.addFlight(flight1);
        airfield2.addFlight(flight2);

        assertEquals("Adding Flights to Airfield failed!", false, airfield1.isFlightsEmpty());
        assertEquals("Adding Flights to Airfield failed!", false, airfield2.isFlightsEmpty());
    }

    @Test
    public void AirfieldPrintFlightsTest() throws NoCodeGivenForFlightException{
        Airport airfield = new Airport( );
        Flight flight1 = new Flight();
        flight1.setCode("C");
        Flight flight2 = new Flight();
        flight2.setCode("F");

        airfield.addFlight(flight1);
        airfield.addFlight(flight2);
    }
}
*/