package com.pmc1.environment;

/**
 * Interface for Environments to be used for the PersonGenerator. Elevator systems should be tested in
 * different environments where people are generated with bias towards certain floors during certain times of the day.
 */
public interface Environment {
    public int getStartFloor();
    public int getDestinationFloor();
}
