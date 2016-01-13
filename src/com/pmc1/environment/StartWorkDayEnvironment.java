package com.pmc1.environment;

import java.util.Random;

/**
 * Morning environment that mimics the morning where people are coming into work (start on first floor) and have
 * their destinations set to random floors throughout the building.
 */
public class StartWorkDayEnvironment implements Environment {
    private final double CHANCE_OF_BASE_FLOOR_GENERATION = .95; // 95% of requests will start from base floor
    private final int ZERO = 0;
    private Random random;

    public StartWorkDayEnvironment() {
        random = new Random();
    }

    @Override
    public int getStartFloor(int maxRange) {
        return (random.nextDouble() < CHANCE_OF_BASE_FLOOR_GENERATION) ? ZERO : random.nextInt(maxRange);
    }

    @Override
    public int getDestinationFloor(int maxRange) {
        return random.nextInt(maxRange);
    }
}
