package com.pmc1.environment;

import java.util.Random;

/**
 * Later afternoon environment that mimics the end of the day where people are leaving work (start floor random) and
 * have their destinations be set to the first floor.
 */
public class EndWorkDayEnvironment implements Environment {
    private final double CHANCE_OF_BASE_FLOOR_GENERATION = .05;
    private final double CHANCE_OF_BASE_FLOOR_DESTINATION = .95; // 95% of requests will start from base floor
    private final int ZERO = 0;
    private Random random;

    public EndWorkDayEnvironment() {
        random = new Random();
    }

    @Override
    public int getStartFloor(int maxRange) {
        // We still want people to be generated on the first floor, but if 95% of the people are destined to go to the
        // first floor, none of those 95% can start on the first floor.
        return (random.nextDouble() < CHANCE_OF_BASE_FLOOR_GENERATION / maxRange) ? ZERO : random.nextInt(maxRange - 1) + 1;
    }

    @Override
    public int getDestinationFloor(int maxRange) {
        return (random.nextDouble() < CHANCE_OF_BASE_FLOOR_DESTINATION) ? ZERO : random.nextInt(maxRange);
    }
}
