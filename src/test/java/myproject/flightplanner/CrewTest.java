package myproject.flightplanner;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CrewTest {

    @Test
    public void CrewDefaultNameIsNull(){
        Crew crew = new Crew();
        assertEquals("Crew name is not null by default", null, crew.getName());
    }

    @Test
    public void WrongCrewAssignedName(){
        Crew crew = new Crew();
        crew.setName("Adam");
        assertEquals("Crew name is not the one you assigned!", "Adam", crew.getName());
    }

    @Test
    public void CrewJobIsNotInitialized(){
        Crew crew1 = new Crew( );
        crew1.setName("Józsi");
        crew1.setCrewJob(CrewJob.PILOT);

        assertEquals("Crew Job is not declared for the crew member!", CrewJob.PILOT, crew1.getCrewJob());
    }


}
