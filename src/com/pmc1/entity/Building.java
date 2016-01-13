package com.pmc1.entity;

import java.util.ArrayList;

/**
 * The Building class is the largest entity which holds number of floors, elevators, people,
 * (algorithms, and floors?).
 *
 * Created by Paul on 10/26/2015.
 */
public class Building {
    private final int elevatorMaxCapacity;
    private final int numFloors;
    private final int numElevators;

    private ArrayList<Elevator> elevatorList;
    private ArrayList<Floor> floorList; // TODO: change to to linked list
    // private ArrayList<Person> allPeople; TODO: is this necessary to have?

    public Building(final int elevatorMaxCapacity, final int numFloors, final int numElevators) {
        this.elevatorMaxCapacity = elevatorMaxCapacity;
        this.numFloors = numFloors;
        this.numElevators = numElevators;

        elevatorList = new ArrayList<Elevator>();
        floorList = new ArrayList<Floor>();
        generateElevatorsAndFloors();
    }

    private void generateElevatorsAndFloors() {
        for (int i = 0; i < numFloors; i++) {
            Floor floor = new Floor(i, elevatorList);
            floorList.add(i, floor);
        }

        for (int j = 0; j < numElevators; j++) {
            Elevator elevator = new Elevator(j, elevatorMaxCapacity, floorList);
            elevatorList.add(j, elevator);
        }
    }

    public ArrayList<Elevator> getElevatorList() {
        return elevatorList;
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }
}
