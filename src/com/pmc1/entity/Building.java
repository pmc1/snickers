package com.pmc1.entity;

import java.lang.reflect.Array;
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
    private ArrayList<Floor> floorList; // should this be a linked list?
    // private ArrayList<Person> allPeople; TODO: is this necessary to have?

    public Building(final int elevatorMaxCapacity, final int numFloors, final int numElevators) {
        this.elevatorMaxCapacity = elevatorMaxCapacity;
        // We are making the assumption that the number of elevators are equal to the number of floors
        this.numFloors = numFloors;
        this.numElevators = numElevators;

        elevatorList = new ArrayList<Elevator>();
        floorList = new FloorList<Floor>();
        generateElevatorsAndFloors();
    }

    private void generateElevatorsAndFloors() {
        for (int i = 0; i < numFloors; i++) {
            Floor floor = new Floor(i, elevatorList);
            floorList.add(i, floor);
        }

        for (int j = 0; j < numElevators; j++) {
            Elevator elevator = new Elevator(i, elevatorMaxCapacity, floorList);
            elevatorList.add(i, elevator);
        }
    }
}
