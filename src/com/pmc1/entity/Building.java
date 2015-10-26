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
    private final int numFloors;

    private ArrayList<Elevator> elevatorGroup;
    // private ArrayList<Person> allPeople; TODO: is this necessary to have?

    public Building(final int numFloors) {
        // We are making the assumption that the number of elevators are equal to the number of floors
        this.numFloors = numFloors;
    }
}
