package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class AirFieldTest {


    @Test
    public void AirfieldDefaultNameIsNull(){
        AirField airfield = new AirField( );
            assertEquals("Airfield has no defined name!",null, airfield.getName( ));
    }

    @Test
    public void AirfieldDefaultAssignedFlights(){
        AirField airfield = new AirField( );
        assertEquals("Default count of Flights on Airfield isn't empty!", true, airfield.isFlightsEmpty());

    }

    @Test (expected = NoCodeGivenForFlightException.class)
    public void AirfieldCheckAssignedFlights() throws NoCodeGivenForFlightException{
        AirField airfield = new AirField( );
        Flight flight = new Flight();
        airfield.addFlight(flight);
        assertEquals("Airfield without Flights, after assignment!", false, airfield.isFlightsEmpty());

    }



}