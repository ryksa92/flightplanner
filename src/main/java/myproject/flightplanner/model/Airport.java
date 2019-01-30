package myproject.flightplanner.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Airport {

    @NotNull
    @Size(min = 4)
    private String name = null;

    public String getName() throws NoNameGivenForAirportException {
        if(name.length() == 0){
            throw new NoNameGivenForAirportException("No name given for Airport.");
        }
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Airport() {

    }
    public Airport (String name) {
        this.name = name;
    }

}
