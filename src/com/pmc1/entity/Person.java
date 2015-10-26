package com.pmc1.entity;

/**
 * The Person class represents the basic user of the elevator system that holds
 * its current floor and destination floor.
 *
 * Created by Paul on 10/26/2015.
 */
public class Person {
    private final Floor destination;

    private boolean inElevator = false;

    public Person(final Floor destination) {
        this.destination = destination;
    }

    public Floor getDestination() {
        return destination;
    }

    public void setInElevator(boolean inElevator) {
        this.inElevator = inElevator;
    }
}
