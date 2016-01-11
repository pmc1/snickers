package com.pmc1.environment;

import java.util.Random;

/**
 * Later afternoon environment that mimics the end of the day where people are leaving work (start floor random) and
 * have their destinations be set to the first floor.
 */
public class EndWorkDayEnvironment implements Environment {
    private final double CHANCE_OF_BASE_FLOOR_GENERATION = .95; // 95% of requests will start from base floor
    private final int ZERO = 0;
    private Random random;
    private int floorSize;

    public EndWorkDayEnvironment(int floorSize) {
        random = new Random();
        this.floorSize = floorSize;
    }

    @Override
    public int getStartFloor() {
        return random.nextInt(floorSize);
    }

    @Override
    public int getDestinationFloor() {
        return (random.nextDouble() < CHANCE_OF_BASE_FLOOR_GENERATION) ? ZERO : random.nextInt(floorSize);
    }
}
