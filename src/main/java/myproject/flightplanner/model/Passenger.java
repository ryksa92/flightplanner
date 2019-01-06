package myproject.flightplanner.model;

public class Passenger extends Person {

    private int checkedBagsInKg = 0;

    public int getCheckedBagsInKg() {
        return checkedBagsInKg;
    }

    public void setCheckedBagsInKg(int checkedBagsInKg) {
        this.checkedBagsInKg = checkedBagsInKg;
    }
}
