package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class PassengerTest {

    @Test
    public void PassengerDefaultNameIsNull(){
        Passenger passenger = new Passenger();
        assertEquals("Passenger name isn't null by default", null, passenger.getName());
    }

    @Test
    public void PassengerAssignedNameFailed(){
        Passenger passenger = new Passenger();
        passenger.setName("Pitbull");
        assertEquals("Passenger name isn't the one you assigned!", "Pitbull", passenger.getName());
    }

    @Test
    public void PassengerDefaultBagsIsZero(){
        Passenger passenger = new Passenger();
        assertEquals("Passenger bags value isn't zero by default", 0, passenger.getCheckedBagsInKg());
    }

    @Test
    public void PassengerAssignedBagsFailed(){
        Passenger passenger = new Passenger();
        passenger.setCheckedBagsInKg(2);
        assertEquals("Passenger bags value isn't the one you assigned!", 2, passenger.getCheckedBagsInKg());
    }

}
