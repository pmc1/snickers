package com.pmc1.entity;

import java.util.ArrayList;

/**
 * The Floor class holds the number of people waiting on the Elevator and the number of Elevators.
 * Created by Paul on 10/26/2015.
 */
public class Floor {
    private final int floorNumber;
    private final ArrayList<Elevator> elevators;

    private ArrayList<Person> peopleOnFloor; //TODO: Should we have two lists, for people going up and down?


    public Floor(final int floorNumber, final ArrayList<Elevator> elevators) {
        this.floorNumber = floorNumber;
        this.elevators = elevators;
        peopleOnFloor = new ArrayList<Person>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

//    public ArrayList<Elevator> getElevators() {
//        return elevators;
//    }
//
    public ArrayList<Person> getPeopleOnFloor() {
        return peopleOnFloor;
    }

    /**
     * Request method from elevator to pick up occupants in floor to elevator.
     *
     * TODO: Add concurrency support from different elevators
     *
     * @param elevatorNumber - The elevator number from the request
     * @param elevatorPeople - The arrayList of occupants from elevator
     * @param elevatorMaxCapacity - The maximum capacity of the elevator occupant count
     * @param state - Elevator state: up, down, stationary
     * @param floorsOfInterest - The floors of interest from Elevator
     */
    public void sendOccupantsToElevator(int elevatorNumber, ArrayList<Person> elevatorPeople, int elevatorMaxCapacity,
            Elevator.ElevatorState state, int[] floorsOfInterest) {
        //Elevator elevator = elevators.get(elevatorNumber);
        if (peopleOnFloor.size() <= 0) return;

        // Pick up passengers
        for (int i = 0; i < peopleOnFloor.size(); i++) {
            if (elevatorPeople.size() >= elevatorMaxCapacity) break;

            //TODO: if we decide to have two lists, this would be a lot simpler...
            // Match elevator state with people who want to be going in the same direction, remove them from the floor list,
            // and onto the elevator list.
            if ((state.getValue() == (peopleOnFloor.get(i).getDestination().compareTo(this)))) {
                Person person = peopleOnFloor.remove(i);
                elevatorPeople.add(person);
                floorsOfInterest[person.getDestination().getFloorNumber()] = 1;
            }
        }

        // Elevator picked up as much compatible passengers as possible
        floorsOfInterest[floorNumber] = 0;
    }

    // Simple compareTo method of floors and their int values.
    // TODO: Temp placeholder, as there is most definitely a more elegant solution that I'm not seeing/will get to.
    public int compareTo(Floor floor) {
        //TODO: do some null checking;
        if (this.floorNumber > floor.getFloorNumber()) {
            return 1;
        } else if (this.floorNumber < floor.getFloorNumber()) {
            return -1;
        } else {
            //TODO: add some logging, as this comparison shouldn't happen
            return 0;
        }
    }
}
