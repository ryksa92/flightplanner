package myproject.flightplanner.model;

public class Person {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    Person(){

    }

    Person(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
