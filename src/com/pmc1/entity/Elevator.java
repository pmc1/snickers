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

    /**
     * Remove people from elevator that want to go to the current floor. Generally this method gets called
     * pickUpPassengers. The assumption that no asshole people exist in this elevator system is made.
     */
    public void dropOffPassengers() {
        for (Person person : peopleInElevator) {
            if (person.getDestination().equals(currentFloor)) {
                peopleInElevator.remove(person);
            }
        }
    }

    /**
     * Adds people into the elevator, by removing them from the floor.
     * @param peopleOnFloor - ArrayList of people who want to enter the elevator. Doesn't necessarily mean
     *                      that everyone will get on, depending on the capacity/size of the elevator
     */
    public void pickUpPassengers(ArrayList<Person> peopleOnFloor) {
        // Pick up passengers
        while (peopleInElevator.size() <= maxCapacity) {
            Person person = peopleOnFloor.remove(0);
            peopleInElevator.add(person);
            floorsOfInterest[person.getDestination().getFloorNumber() - 1] = 1;
        }

        // Elevator picked up as much compatible passengers as possible
        floorsOfInterest[currentFloor.getFloorNumber() - 1] = 0;
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
        if (floorNumber >= 1 && floorNumber <= floors.size()) return; // TODO: add error logging
        floorsOfInterest[floorNumber - 1] = 1;
    }

    public int[] getFloorsOfInterest() {
        return floorsOfInterest;
    }

    /**
     * Simple enum class that represents the different elevator states.
     */
    public enum ElevatorState {
        UP, DOWN, STATIONARY;
    }
}
