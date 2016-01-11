package com.pmc1.environment;

import java.util.Random;

/**
 * Random Environment where start and destination floors are randomized. Uses Random.nextInt().
 */
public class RandomEnvironment implements Environment {
    private int floorSize;

    public RandomEnvironment(int floorSize) {
        this.floorSize = floorSize;
    }

    @Override
    public int getStartFloor() {
        return new Random().nextInt(floorSize);
    }

    @Override
    public int getDestinationFloor() {
        return getStartFloor();
    }
}
