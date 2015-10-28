package com.pmc1.system;

import com.pmc1.entity.Floor;

/**
 * Base class of all types of Elevator systems. These elevator systems interact with floors (request
 * for an elevator with direction and/or floor) and elevators (direction for going to specific floor).
 *
 * Created by Paul on 10/28/2015.
 */
public abstract class BaseElevatorSystem {
    /**
     * Floor request for whenever there is a new request for going up or down
     * @param goingUp - true for up, false for down
     */
    public abstract void floorRequest(boolean goingUp);

    /**
     * Elevator request for whenever there is a new request for going to a specific floor
     * @param floor - requested floor for passenger
     */
    public abstract void elevatorRequest(Floor floor);
}
