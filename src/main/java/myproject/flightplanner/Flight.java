package myproject.flightplanner;

import java.util.HashMap;
import java.util.Map;

public class Flight {

    private String code;
    private HashMap<String, Person> people = new HashMap<>( );


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addPeople(Person person) {
        people.put(person.getName( ), person);
    }

    public void printCrew() {
        System.out.println(" -- Crew members: ");
        for (Map.Entry<String, Person> crewMember : people.entrySet( )) {
            if (crewMember.getClass().isAssignableFrom(Crew.class)) {
                System.out.print(crewMember.getValue( ).getName( ) + ", ");
            }
        }
    }

    public void printPassengers() {
        System.out.println(" -- Passengers: ");
        for (Map.Entry<String, Person> passenger : people.entrySet( )) {
            if (passenger.getClass().isAssignableFrom(Passenger.class)) {
                System.out.print(passenger.getValue( ).getName( ) + ", ");
            }
        }
    }
}
