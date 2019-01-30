package myproject.flightplanner.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Passenger extends Person {

    @NotNull
    @Size(min = 1, max = 3)
    private int checkedBagsInKg;

    public Passenger(String name, int checkedBagsInKg) {
        super(name);
        this.checkedBagsInKg = checkedBagsInKg;
    }

    public int getCheckedBagsInKg() {
        return checkedBagsInKg;
    }
}
