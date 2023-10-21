package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Random RANDOM = new Random();
    private static final double FAULTY_CONNECTION_PROBABILITY = 0.3;

    @Override
    public Connection getConnection() {
        if (RANDOM.nextDouble() < FAULTY_CONNECTION_PROBABILITY) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}

