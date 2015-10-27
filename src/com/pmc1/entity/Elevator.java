package com.pmc1.entity;

import java.util.ArrayList;

/**
 * The Elevator class holds small groups of people that delivers them to their respective
 * selected destination floor.
 *
 * As of now, we are assuming that every Elevator has access to all floors.
 * TODO: Add floor restriction to be used for certain algorithms in the future.
 *
 * Created by Paul on 10/26/2015.
 */
public class Elevator {
    private final int elevatorNumber;
    private final int maxCapacity;
    private final ArrayList<Floor> floors;

    private Floor currentFloor;
    private int[] floorsOfInterest;
    private ArrayList<Person> peopleInElevator;
    private ElevatorState state;

    public Elevator(int elevatorNumber, final int maxCapacity, ArrayList<Floor> floors) {
        this.elevatorNumber = elevatorNumber;
        this.maxCapacity = maxCapacity;
        this.floors = floors;
        // Assuming that ground floor is equivalent to lobby and first floor. As it should be.
        currentFloor = this.floors.get(1);
        state = ElevatorState.STATIONARY;
        floorsOfInterest = new int[floors.size()];
    }

    public void dropOffPassengers() {
        for (Person person : peopleInElevator) {
            if (person.getDestination().equals(currentFloor)) {
                peopleInElevator.remove(person);
            }
        }
    }

    public void pickUpPassengers(ArrayList<Person> peopleOnFloor) {
        while (peopleInElevator.size() <= maxCapacity) {
            Person person = peopleOnFloor.remove(0);
            peopleInElevator.add(person);
            floorsOfInterest[person.getDestination().getFloorNumber() - 1] = 1;
        }
    }

    public void setElevatorState(ElevatorState state) {
        this.state = state;
    }

    public enum ElevatorState {
        UP, DOWN, STATIONARY;
    }
}
