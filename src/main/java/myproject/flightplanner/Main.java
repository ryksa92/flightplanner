package myproject.flightplanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName( ));
    private static final Logger rootLogger = LogManager.getLogManager( ).getLogger("");

    private static Map<String, AirField> airfields = new HashMap<>( );
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String PARSET_MESSAGE = "$$$ Declared parameter(s) have been set successfully! $$$";
    private static final String INTROMESSAGE = "Please create an Airfield first! then assign a flight, passengers, crew members to it!";
    private static final String SEPARATOR = "**********************************************************************************";
    private static final String REGEX_ONLY_STRING = "^[A-Z][a-z]+$";
    private static final String REGEX_ONLY_NUMBER = "^[0-9]*$";
    private static final String REGEX_COMPLETE = "^[A-Z][.]+$";

    public static void main(String[] args) throws IOException {

        logger.info("FlightPlanner.");
        rootLogger.setLevel(Level.INFO);

        boolean looperMain = true;
        while (looperMain) {
            printIntroCommands( );
            String line = reader.readLine( );

            switch (line.toLowerCase( )) {
                case "exit":
                    looperMain = false;
                    break;

                case "a":
                    createAirfield( );
                    break;

                case "f":
                    if (isAirfieldsMapEmpty( )) {
                        System.out.println(INTROMESSAGE);
                        break;
                    }
                    createFlight( );
                    break;

                case "p":
                    if (isAllFlightsMapEmpty( )) {
                        System.out.println(INTROMESSAGE);
                        break;
                    }

                    createPassenger( );
                    break;

                case "c":
                    if (isAllFlightsMapEmpty( )) {
                        System.out.println(INTROMESSAGE);
                        break;
                    }

                    Crew crewMember = new Crew( );
                    setCrewName(crewMember);
                    assignCrewToFlight(crewMember);
                    setCrewJob(crewMember);
                    break;

                case "getlist":
                    if (isAirfieldsMapEmpty( )) break;
                    getDatabaseList( );
                    break;

                default:
                    printSwitchDefaultMessage( );
                    break;
            }
        }
    }

    private static void printIntroCommands() {

        System.out.println(SEPARATOR);
        System.out.println("Create a new...: a - AIRPORT, f - FLIGHT, p - PASSENGER, c - CREW MEMBER");
        System.out.println("Other input commands: getlist - show the complete list of airports along with their associated flights, exit - EXIT PROGRAM");
        System.out.println(SEPARATOR);

        if (airfields.size( ) == 0) {
            System.out.println("[TIP: Create an Airfield first in order to register flights and members on it/them.]");
        }
        System.out.println( );
        System.out.print("Enter: ");
    }

    private static boolean isAirfieldsMapEmpty() {
        if (airfields.size( ) == 0) return true;
        return false;
    }

    private static boolean isAllFlightsMapEmpty() {
        for (Map.Entry<String, AirField> airFieldEntry : airfields.entrySet( )) {
            if (!airFieldEntry.getValue( ).isFlightsEmpty( )) {
                return false;
            }
        }
        return true;
    }

    private static void getListAirfields() {
        System.out.println( );
        System.out.println("Airfields: ");
        for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
            System.out.printf("[%s] ", airfieldEntry.getKey( ));
        }
    }

    private static void createAirfield() throws IOException {

        System.out.print("Airfield's name (any character): ");
        String nameAirfield = reader.readLine( );

        AirField airfield = new AirField( );
        try {
            airfield.setName(nameAirfield);
        } catch (NullPointerException error) {
            error.getStackTrace( );
        }
        try {
            airfields.put(airfield.getName( ), airfield);
        } catch (NoNameGivenForAirfieldException error) {
            error.getStackTrace( );
        }
        System.out.println( );
        System.out.println(PARSET_MESSAGE);
        System.out.println( );
        if (!airfields.containsKey(nameAirfield)) {
            try {
                System.out.printf("The Airfield name of %s is already taken! Define a new one!", airfields.get(nameAirfield).getName( ));
                System.out.println( );
            } catch (NoNameGivenForAirfieldException error) {
                error.getStackTrace( );
            }
        }
    }

    private static void createFlight() throws IOException {

        System.out.println("Flight's code (first uppercase, then any character!): ");
        String codeFlight = reader.readLine( );

        if (codeFlight.matches(REGEX_COMPLETE)) {
            Flight flight = new Flight( );
            System.out.println( );
            System.out.println(PARSET_MESSAGE);
            flight.setCode(codeFlight);
            System.out.println("Choose one of the Airfields below by typing its name!");

            boolean looperFlight = true;
            while (looperFlight) {
                getListAirfields( );
                System.out.println( );

                String assignedAirfieldName = reader.readLine( );
                if (airfields.containsKey(assignedAirfieldName)) {
                    try {
                        airfields.get(assignedAirfieldName).addFlight(flight);
                        System.out.printf("$$$ [Flight:%s] has been assigned to [Airport:%s]! $$$", flight.getCode( ), airfields.get(assignedAirfieldName).getName( ));
                    } catch (NoCodeGivenForFlightException | NoNameGivenForAirfieldException error) {
                        error.getStackTrace( );
                    }
                    looperFlight = false;
                } else {
                    System.out.println("Incorrect airfield name! Try again with only the available airfield names!");
                    looperFlight = false;
                }
            }
        } else if (airfields.containsKey(codeFlight)) {
            System.out.printf("The Flight code of %s is already taken! Define a new one!", codeFlight);
        }
    }

    private static void createPassenger() throws IOException {

        System.out.print("Passenger's name (first uppercase, then lowercase alphabets): ");
        String namePassenger = reader.readLine( );

        if (namePassenger.matches(REGEX_ONLY_STRING)) {
            Passenger passenger = new Passenger( );
            passenger.setName(namePassenger);

            setPassengerCheckedBags(passenger);
            printAvailableFlights( );

            System.out.println( );
            String assignPassengerToFlightCode = reader.readLine( );

            for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
                if (airfieldEntry.getValue( ).getFlights( ).containsKey(assignPassengerToFlightCode)) {
                    try {
                        airfieldEntry.getValue( ).getFlights( ).get(assignPassengerToFlightCode).addPeople(passenger);
                    } catch (NoNameGivenForPersonException error) {
                        logger.info(error.getMessage( ));
                    }
                    System.out.printf("$$$ [Passenger:%s] has been assigned to [Flight:%s]! $$$", passenger.getName( ), airfieldEntry.getValue( ).getFlights( ).get(assignPassengerToFlightCode).getCode( ));
                    System.out.println( );
                }
            }
        } else if (airfields.containsKey(namePassenger) || (!namePassenger.matches(REGEX_ONLY_STRING))) {
            System.out.println("Invalid input! Type another name!");
        }
    }

    private static void printAvailableFlights() {
        System.out.println("Choose an initiated Flight for the Passenger by the code of the Flight!");
        for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
            try {
                airfieldEntry.getValue( ).printFlights( );
            } catch (NoCodeGivenForFlightException error) {
                error.getStackTrace( );
            }
        }
    }

    private static void setPassengerCheckedBags(Passenger passenger) throws IOException {

        System.out.println( );
        System.out.printf("Assign %s's checked bags value (in Kg): ", passenger.getName( ));
        String bagsPassenger = reader.readLine( );

        if (bagsPassenger.matches(REGEX_ONLY_NUMBER)) {
            passenger.setCheckedBagsInKg(Integer.parseInt(bagsPassenger));
        }
        System.out.println(PARSET_MESSAGE);
        System.out.println( );
    }

    private static void setCrewName(Crew crewMember) throws IOException {

        System.out.print("Crew member's name (first uppercase, then lowercase alphabets): ");
        String nameCrew = reader.readLine( );

        if (airfields.containsKey(nameCrew) && nameCrew.matches(REGEX_ONLY_STRING)) {
            System.out.printf("The Crew member name of %s is already taken! Define a new one!", airfields.get(nameCrew));
        } else if (!nameCrew.matches(REGEX_ONLY_STRING)) {
            System.out.println("As a name you must use only characters: first an upper- then lowercase letters! Try again!");
        } else {
            crewMember.setName(nameCrew);
        }
    }

    private static void assignCrewToFlight(Crew crewMember) throws IOException {

        System.out.println("Choose an initiated Flight for the Crew by the code of the Flight!");

        boolean looperAssignCrew = true;
        while (looperAssignCrew) {
            for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
                try {
                    airfieldEntry.getValue( ).printFlights( );
                } catch (NoCodeGivenForFlightException error) {
                    error.getStackTrace( );
                }
            }
            System.out.println( );
            String assignCrewMemberToFlightCode = reader.readLine( );
            for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
                if (airfieldEntry.getValue( ).getFlights( ).containsKey(assignCrewMemberToFlightCode)) {
                    try {
                        airfieldEntry.getValue( ).getFlights( ).get(assignCrewMemberToFlightCode).addPeople(crewMember);
                    } catch (NoNameGivenForPersonException error) {
                        error.getStackTrace( );
                    }
                    System.out.printf("$$$ Crew member [%s - %s] has been assigned to the Flight [%s]! $$$", crewMember.getName( ), crewMember.getCrewJob( ), airfieldEntry.getValue( ).getFlights( ).get(assignCrewMemberToFlightCode).getCode( ));
                    System.out.println( );
                    looperAssignCrew = false;
                }
            }
            if (looperAssignCrew) {
                System.out.println("Invalid Flight code. Couldn't assign to it! Choose a valid option!");
            }
        }
    }

    private static void setCrewJob(Crew crewMember) throws IOException {

        boolean looperCrewJob = true;
        while (looperCrewJob) {

            System.out.printf("Choose %s's job-type, type in: p - Pilot, m - Mechanic, a - Flight Attendant, cp - CoPilot", crewMember.getName( ));
            System.out.println( );
            switch (reader.readLine( ).toUpperCase( )) {
                case "P":
                    crewMember.setCrewJob(CrewJob.PILOT);
                    System.out.println(PARSET_MESSAGE);
                    looperCrewJob = false;
                    break;

                case "M":
                    crewMember.setCrewJob(CrewJob.MECHANIC);
                    System.out.println(PARSET_MESSAGE);
                    System.out.println( );
                    looperCrewJob = false;
                    break;

                case "CP":
                    crewMember.setCrewJob(CrewJob.COPILOT);
                    System.out.println(PARSET_MESSAGE);
                    System.out.println( );
                    looperCrewJob = false;
                    break;

                case "A":
                    crewMember.setCrewJob(CrewJob.FLIGHT_ATTENDANT);
                    System.out.println(PARSET_MESSAGE);
                    System.out.println( );
                    looperCrewJob = false;
                    break;

                default:
                    System.out.println("Incorrect input. Please choose a correct one!");
                    System.out.println( );
                    break;
            }
        }
    }

    private static void getDatabaseList() {
        for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
            for (Map.Entry<String, Flight> flightEntry : airfieldEntry.getValue( ).getFlights( ).entrySet( )) {
                System.out.println( );
                System.out.println("----##### The FlightPlanner DataBase #####----");
                System.out.printf("Total number of Airfields: %d, Flights: %d, Passengers: %d, Crew members: %d.", airfields.size( ), airfieldEntry.getValue( ).getFlights( ).size( ), flightEntry.getValue( ).getNumbersOfPassengers( ), flightEntry.getValue( ).getNumbersOfCrew( ));
                System.out.println( );
            }
        }
        for (Map.Entry<String, AirField> airfieldEntry : airfields.entrySet( )) {
            System.out.println( );
            try {
                System.out.println("[Airfield : " + airfieldEntry.getValue( ).getName( ) + "]");
            } catch (NoNameGivenForAirfieldException error) {
                error.getStackTrace( );
            }

            for (Map.Entry<String, Flight> flightEntry : airfieldEntry.getValue( ).getFlights( ).entrySet( )) {
                System.out.println(" - [Flight: " + flightEntry.getValue( ).getCode( ) + "]");
                try {
                    flightEntry.getValue( ).printCrew( );
                } catch (NoJobDeclaredException | NoCrewDeclaredException error) {
                    error.getStackTrace( );
                }
                System.out.println( );
                flightEntry.getValue( ).printPassengers( );
            }
        }
    }

    private static void printSwitchDefaultMessage() {
        System.out.println( );
        System.out.println("Error: Incorrect input. Choose from the options below!");
        System.out.println( );
    }
}


