package edu.hw7.Task1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Counter {
    private static final int NUM_THREADS = 5;
    private static final int ITERATIONS = 5000;
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final Logger logger = Logger.getLogger(Counter.class.getName());

    public static int run() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            Future<?> future = executor.submit(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    count.incrementAndGet();
                }
            });

            future.get();
        } catch (ExecutionException | InterruptedException e) {
            logger.log(Level.SEVERE, "Exception during execution", e);
            System.err.println("Exception logged: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

        return count.get();
    }
}



