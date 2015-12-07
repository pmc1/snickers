package com.pmc1.entity;

import java.util.ArrayList;

/**
 * The Floor class holds the number of people waiting on the Elevator and the number of Elevators.
 * Created by Paul on 10/26/2015.
 */
public class Floor {
    private final int floorNumber;
    private final ArrayList<Elevator> elevators;

    private ArrayList<Person> peopleOnFloor;


    public Floor(final int floorNumber, final ArrayList<Elevator> elevators) {
        this.floorNumber = floorNumber;
        this.elevators = elevators;
        peopleOnFloor = new ArrayList<Person>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    public ArrayList<Person> getPeopleOnFloor() {
        return peopleOnFloor;
    }

    /**
     * Request method from elevator to pick up occupants in floor to elevator.
     *
     * TODO: Add concurrency support from different elevators
     * @param elevatorNumber
     * @param elevatorPeopleSize
     * @param elevatorMaxCapacity
     */
    public void sendOccupantsToElevator(int elevatorNumber, int elevatorPeopleSize, int elevatorMaxCapacity,
            Elevator.ElevatorState state) {
        Elevator elevator = elevators.get(elevatorNumber);

        // Pick up passengers
        while (peopleInElevator.size() <= maxCapacity) {
            Person person = peopleOnFloor.remove(0);
            peopleInElevator.add(person);
            floorsOfInterest[person.getDestination().getFloorNumber() - 1] = 1;
        }

        // Elevator picked up as much compatible passengers as possible
        floorsOfInterest[currentFloor.getFloorNumber() - 1] = 0;

    }

    public boolean equals(Floor floor) {
        if (floor == null || floor.getFloorNumber() < 1 || floorNumber < 1) {
            return false;
        }

        return this.floorNumber == floor.getFloorNumber();
    }
}
