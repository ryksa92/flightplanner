package myproject.flightplanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName( ));
    private static final Logger rootLogger = LogManager.getLogManager( ).getLogger("");

    private static Map<String, AirField> airfields = new HashMap<>( );

    private static final String PARSET_MESSAGE = "$$$ All previously declared parameter has been set successfully! $$$";
    private static final String STATIC_NULLMESSAGE = "Please create an airfield first! then assign a flight, passengers, crew members to it!";
    private static int numberOfAirfields = 0;
    private static int numberOfFlights = 0;
    private static int numberOfPassengers = 0;
    private static int numberOfCrew = 0;
    private static final String regexOnlyString = "[A-Z][a-z]+";
    private static final String regexOnlyNumbers = "^[0-9]*$";

    public static void main(String[] args) throws IOException {


        logger.info("Flight planner program.");                                                   //Main class, info logger
        rootLogger.setLevel(java.util.logging.Level.INFO);                                             //Set min. logger level, to see loggers.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                  //writing in/reading from the console
        boolean looperMain = true;

        while (looperMain) {
            System.out.println( );
            System.out.println("**************************************************************************");
            System.out.println("Create a new...: a - AIRFIELD, f - FLIGHT, p - PASSENGER, c - CREW MEMBER");
            System.out.println("Other input commands: getlist - show the complete list of airfields along with their associated flights, exit - EXIT PROGRAM");
            System.out.println("**************************************************************************");

            if (numberOfAirfields == 0) {
                System.out.println("[TIP: Create an airfield first in order to register flights and members on it/them.]");
            }

            System.out.print("Enter: ");
            String line = reader.readLine( );

            switch (line.toLowerCase( )) {
                case "exit":
                    looperMain = false;
                    break;

                case "a":
                    AirField airfield = new AirField( );

                    System.out.println("Airfield's name (any character): ");
                    String nameAirfield = reader.readLine( );

                    if (numberOfAirfields >= 0) {
                        if (airfields.containsKey(nameAirfield)) {
                            System.out.printf("The Airfield name of %s is already taken! Define a new one!", airfields.get(nameAirfield).getName( ));
                        } else {
                            airfield.setName(nameAirfield);
                            airfields.put(airfield.getName( ), airfield);
                            System.out.println( );
                            System.out.printf(PARSET_MESSAGE);
                            System.out.println( );
                            numberOfAirfields++;
                        }
                    }
                    break;

                case "f":
                    if (numberOfAirfields == 0) {
                        System.out.println(STATIC_NULLMESSAGE);
                        break;
                    }

                    Flight flight = new Flight( );

                    System.out.println("Flight's code: ");
                    String codeFlight = reader.readLine( );

                    for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
                        if (airfieldMap.getValue( ).getFlights( ).containsKey(codeFlight)) {
                            System.out.printf("The Flight code of %s is already taken! Define a new one!", airfieldMap.getValue( ).getFlights( ).get(codeFlight).getCode( ));
                            break;
                        } else {
                            flight.setCode(codeFlight);

                            System.out.println( );
                            System.out.printf("The flight's code has been set as [%s]. Flight is created, but not assigned to any airfield! Choose one of them below.", flight.getCode( ));
                            System.out.println( );

                            getListAirfields( );
                            System.out.println( );

                            String assignToAirfieldName = reader.readLine( );

                            if (airfields.containsKey(assignToAirfieldName)) {
                                airfields.get(assignToAirfieldName).addFlight(flight);
                                System.out.printf("*** Flight [%s] has been assigned to the airfield [%s]! ***", flight.getCode( ), airfields.get(assignToAirfieldName).getName( ));
                                numberOfFlights++;
                                break;
                            } else {
                                System.out.println("Incorrect airfield name! Try again with only the available airfield names!");
                                System.out.println( );
                            }
                        }
                    }

                    break;


                case "p":
                    if (numberOfFlights == 0) {
                        System.out.println(STATIC_NULLMESSAGE);
                        break;
                    }

                    Passenger passenger = new Passenger( );

                    System.out.print("Passenger's name (first uppercase, then lowercase alphabets): ");
                    String namePassenger = reader.readLine( );

                    if (namePassenger.matches(regexOnlyString)) {
                            if (airfields.containsKey(namePassenger)) {
                                System.out.printf("The Passenger name of %s is already taken! Define a new one!", airfields.get(namePassenger));
                            } else {
                                passenger.setName(namePassenger);
                                System.out.println( );
                                System.out.printf("Assign %s's checked bags value (in Kg): ", passenger.getName( ));

                                String bagsPassenger = reader.readLine( );
                                if (bagsPassenger.matches(regexOnlyNumbers)) {
                                    passenger.setCheckedBagsInKg(Integer.parseInt(bagsPassenger));
                                }

                                System.out.println(PARSET_MESSAGE);
                                System.out.println( );
                                System.out.println("Choose an initiated Flight for the Passenger by the code of the Flight!");
                                for (Map.Entry<String, AirField> airfields : airfields.entrySet( )) {
                                    airfields.getValue( ).printFlights( );
                                }

                                System.out.println( );
                                String assignToFlightCode = reader.readLine( );
                                for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
                                if (airfieldMap.getValue( ).getFlights( ).containsKey(assignToFlightCode)) {
                                    airfieldMap.getValue( ).getFlights( ).get(assignToFlightCode).addPeople(passenger);
                                    System.out.printf("*** Passenger [%s] has been assigned to the Flight [%s]! ***", passenger.getName( ), airfieldMap.getValue( ).getFlights( ).get(assignToFlightCode).getCode( ));
                                    System.out.println( );
                                    numberOfPassengers++;

                                } else {
                                    System.out.println("Could not find this Flight code try again!");
                                }
                            }
                        }
                    } else {
                        System.out.println("As a name you must use only characters: first an upper- then lowercase letters! Try again!");
                    }
                    break;


                case "c":
                    if (numberOfFlights == 0) {
                        System.out.println(STATIC_NULLMESSAGE);
                        break;
                    }

                    Crew crewMember = new Crew( );
                    numberOfCrew++;
                    System.out.print("Assign the NAME of the crew member: ");
                    crewMember.setName(reader.readLine( ));

                    boolean looperCrewAdder = true;
                    while (looperCrewAdder) {
                        System.out.printf("Choose %s's job-type, type in: p - Pilot, m - Mechanic, a - Flight Attendant, cp - CoPilot", crewMember.getName( ));
                        System.out.println( );

                        switch (reader.readLine( ).toUpperCase( )) {
                            case "P":
                                crewMember.setCrewJob(CrewJob.Pilot);
                                System.out.println(PARSET_MESSAGE);
                                break;

                            case "M":
                                crewMember.setCrewJob(CrewJob.Mechanic);
                                System.out.println(PARSET_MESSAGE);
                                System.out.println( );
                                break;

                            case "CP":
                                crewMember.setCrewJob(CrewJob.CoPilot);
                                System.out.println(PARSET_MESSAGE);
                                System.out.println( );
                                break;

                            case "A":
                                crewMember.setCrewJob(CrewJob.FlightAttendant);
                                System.out.println(PARSET_MESSAGE);
                                System.out.println( );
                                break;

                            default:
                                System.out.println("Incorrect input. Please choose a correct one!");
                                System.out.println( );
                                break;
                        }


                        System.out.println("Choose an initiated Flight for the Crew by the code of the Flight!");

                        for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
                            airfieldMap.getValue( ).printFlights( );
                        }

                        System.out.println( );
                        String flightCodeCrew = reader.readLine( );

                        for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
                            if (airfieldMap.getValue( ).getFlights( ).containsKey(flightCodeCrew)) {
                                airfieldMap.getValue( ).getFlights( ).get(flightCodeCrew).addPeople(crewMember);
                                System.out.printf("*** Crew member [%s - %s] has been assigned to the Flight [%s]! ***", crewMember.getName( ), crewMember.getCrewJob( ), airfieldMap.getValue( ).getFlights( ).get(flightCodeCrew).getCode( ));
                                System.out.println( );
                                looperCrewAdder = false;
                            }
                        }
                    }
                    break;

                case "getlist":

                    if (numberOfAirfields == 0) {
                        System.out.println(STATIC_NULLMESSAGE);
                        break;
                    }

                    System.out.println( );
                    System.out.println("----##### The AirPlanner DataBase #####----");
                    System.out.printf("Total number of airfields: %d, flights: %d, passengers: %d, crew members: %d.", numberOfAirfields, numberOfFlights, numberOfPassengers, numberOfCrew);
                    System.out.println( );
                    for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
                        System.out.println( );
                        System.out.println("[Airfield : " + airfieldMap.getValue( ).getName( ) + "]");
                        for (Map.Entry<String, Flight> flightMap : airfieldMap.getValue( ).getFlights( ).entrySet( )) {
                            System.out.print(" - Flight: ");
                            System.out.println("[" + flightMap.getValue( ).getCode( ) + "]");
                            flightMap.getValue( ).printCrew( );
                            flightMap.getValue( ).printPassengers( );
                        }
                    }
                    break;


                default:
                    System.out.println( );
                    System.out.println("Error: Incorrect input. Choose from the options below!");
                    System.out.println( );
                    break;

            }
        }

    }


    private static void getListAirfields() {                                                           //reading airfields one by one from the ArrayList<AirField> airfields.
        System.out.println("List of available airfields. Type in the name of one of them to assign flights to it!");
        System.out.println( );
        System.out.print("Airfields: ");
        for (Map.Entry<String, AirField> airfieldMap : airfields.entrySet( )) {
            System.out.printf("[%s] ", airfieldMap.getKey( ));
        }
    }
}


