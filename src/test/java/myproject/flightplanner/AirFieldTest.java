package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class AirFieldTest {

    @Test (expected = NoCodeGivenForFlightException.class)
    public void CheckAirfieldIsEmptyOfFlights_NoCode() throws NoCodeGivenForFlightException{
        AirField airfield = new AirField( );

        Flight flight = new Flight();
        airfield.addFlight(flight);

        assertEquals("Airfield is empty (without Flights)!", false, airfield.isFlightsEmpty());
    }

    @Test
    public void CheckAirfieldIsEmptyOfFlights_WithCode() throws NoCodeGivenForFlightException{
        AirField airfield = new AirField( );
        airfield.setName("PC");

        Flight flight1 = new Flight();
        flight1.setCode("AVC");

        airfield.addFlight(flight1);

        assertEquals("", false, airfield.isFlightsEmpty());
    }

    @Test (expected = NoCodeGivenForFlightException.class)
    public void MultipleAirfieldWithAssignedFlightsTest_NoCode() throws NoCodeGivenForFlightException{
        AirField airfield = new AirField( );
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();

        airfield.addFlight(flight1);
        airfield.addFlight(flight2);

        assertEquals("Adding Flights to Airfield failed!", false, airfield.isFlightsEmpty());
    }

    @Test (expected = NoCodeGivenForFlightException.class)
    public void MultipleAirfieldWithAssignedFlightsTest_WithCode() throws NoCodeGivenForFlightException{
        AirField airfield1 = new AirField( );
        Flight flight1 = new Flight();
        AirField airfield2 = new AirField( );
        Flight flight2 = new Flight();

        airfield1.addFlight(flight1);
        airfield2.addFlight(flight2);

        assertEquals("Adding Flights to Airfield failed!", false, airfield1.isFlightsEmpty());
        assertEquals("Adding Flights to Airfield failed!", false, airfield2.isFlightsEmpty());
    }

    @Test
    public void AirfieldPrintFlightsTest() throws NoCodeGivenForFlightException{
        AirField airfield = new AirField( );
        Flight flight1 = new Flight();
        flight1.setCode("C");
        Flight flight2 = new Flight();
        flight2.setCode("F");

        airfield.addFlight(flight1);
        airfield.addFlight(flight2);
    }
}