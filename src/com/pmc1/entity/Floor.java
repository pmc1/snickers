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

    public boolean equals(Floor floor) {
        if (floor == null || floor.getFloorNumber() < 1 || floorNumber < 1) {
            return false;
        }

        return this.floorNumber == floor.getFloorNumber();
    }
}
