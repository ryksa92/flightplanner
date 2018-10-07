package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class PassengerTest {

    @Test
    public void PassengerAssignedNameFailed(){
        Passenger passenger = new Passenger();
        passenger.setName("Pitbull");
        assertEquals("Passenger name isn't the one you assigned!", "Pitbull", passenger.getName());
    }

    @Test
    public void PassengerAssignedBagsFailed(){
        Passenger passenger = new Passenger();
        passenger.setCheckedBagsInKg(2);
        assertEquals("Passenger bags value isn't the one you assigned!", 2, passenger.getCheckedBagsInKg());
    }

}
