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
    private int[] floorsOfInterest; // TODO: determine if this should this exist in the Elevator System or
                                    // in the Elevator itself?
    private ArrayList<Person> peopleInElevator;
    private ElevatorState state;

    public Elevator(final int elevatorNumber, final int maxCapacity, ArrayList<Floor> floors) {
        this.elevatorNumber = elevatorNumber;
        this.maxCapacity = maxCapacity;
        this.floors = floors;
        // Assuming that ground floor is equivalent to lobby and first (0th) floor.
        currentFloor = this.floors.get(0);
        state = ElevatorState.STATIONARY;
        floorsOfInterest = new int[floors.size()];
    }

    /**
     * Remove people from elevator that want to go to the current floor. Generally this method gets called before
     * pickUpPassengers.
     */
    public void dropOffPassengers() {
        for (Person person : peopleInElevator) {
            if (person.getDestination().equals(currentFloor)) {
                peopleInElevator.remove(person);
            }
        }
    }

    /**
     * Send request to floor to add relevant occupants into the elevator. The heart of this method lives in the
     * Floor class because of the possibility of concurrent requests being made on the same floor.
     */
    public void pickUpPassengers() {
        currentFloor.sendOccupantsToElevator(elevatorNumber, peopleInElevator, maxCapacity, state, floorsOfInterest);
    }

    /**
     * 'Moves' elevator to specified floor with some basic checks.
     * @param floor - the specified floor which the currentFloor of the elevator will be set to be
     */
    public void moveToFloor(Floor floor) {
        if (floor.getFloorNumber() > currentFloor.getFloorNumber() && state == ElevatorState.UP) {
            // TODO: add some logic with going from floor to floor rather than jumping to floors
            currentFloor = floor;
        } else if (floor.getFloorNumber() < currentFloor.getFloorNumber() && state == ElevatorState.DOWN) {
            currentFloor = floor;
        } else {
            // same floor
            // TODO: log error message as this shouldn't have occurred
        }
    }

    /**
     * Set elevator state to specified state.
     * @param state - Elevator state which is UP, DOWN, or STATIONARY
     */
    public void setElevatorState(ElevatorState state) {
        this.state = state;
    }

    /**
     * Sets elevator's floorsOfInterest to be true for a specified floor.
     * @param floorNumber - floor number before subtracting one (array indices)
     */
    public void addFloorToInterest(int floorNumber) {
        if (floorNumber < 0 && floorNumber >= floors.size()) return; // TODO: add error logging
        floorsOfInterest[floorNumber] = 1;
    }

    public int[] getFloorsOfInterest() {
        return floorsOfInterest;
    }

    /**
     * Simple enum class that represents the different elevator states.
     */
    public enum ElevatorState {
        UP(1),
        DOWN(-1),
        STATIONARY(0);

        private final int value;

        ElevatorState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
