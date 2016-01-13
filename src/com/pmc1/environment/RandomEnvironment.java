package com.pmc1.environment;

import java.util.Random;

/**
 * Random Environment where start and destination floors are randomized. Uses Random.nextInt().
 */
public class RandomEnvironment implements Environment {
    private int floorSize;
    private Random random;

    public RandomEnvironment(int floorSize) {
        random = new Random();
    }

    @Override
    public int getStartFloor(int maxRange) {
        return random.nextInt(floorSize);
    }

    @Override
    public int getDestinationFloor(int maxRange) {
        return getStartFloor(maxRange);
    }
}
