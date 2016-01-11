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
    private int floorSize;

    public StartWorkDayEnvironment(int floorSize) {
        random = new Random();
        this.floorSize = floorSize;
    }

    @Override
    public int getStartFloor() {
        return (random.nextDouble() < CHANCE_OF_BASE_FLOOR_GENERATION) ? ZERO : random.nextInt(floorSize);
    }

    @Override
    public int getDestinationFloor() {
        return random.nextInt(floorSize);
    }
}
