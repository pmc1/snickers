package com.pmc1.system;

import com.pmc1.entity.Floor;

/**
 * Very primitive elevator system that processes floor requests in the order that it receives input.
 * Elevators are given people based on the closest elevator about to pass the floor.
 *
 * Created by Paul on 10/28/2015.
 */
public class FirstRequestProcessedSystem extends BaseElevatorSystem {

    public void floorRequest(boolean goingUp) {
        // first find an elevator that should pick up this request

        // set that elevator's floorsOfInterest to be true for that specific floor
    }

    public void elevatorRequest(Floor floor) {
        // process request in the order of request given because of naive implementation
    }
}
