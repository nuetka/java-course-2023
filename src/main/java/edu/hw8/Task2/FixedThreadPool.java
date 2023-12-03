package edu.hw8.Task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FixedThreadPool implements ThreadPool {
    private final int poolSize;
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threads;

    FixedThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new ArrayBlockingQueue<>(poolSize);
        this.threads = new Thread[poolSize];
    }

    @Override
    public void start() {
        for (int i = 0; i < poolSize; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

