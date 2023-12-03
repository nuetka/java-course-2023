package edu.hw8.Task2;

public class FibonacciCalculator implements Runnable {
    private final int n;
    private int result;

    public FibonacciCalculator(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        result = calculateFibonacci(n);
    }

    public int getResult() {
        return result;
    }

    private int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    @SuppressWarnings({"MagicNumber", "uncommentedmain"})
    public static void main(String[] args) throws Exception {
        try (ThreadPool threadPool = new FixedThreadPool(4)) {
            threadPool.start();

            // Calculate Fibonacci numbers in parallel
            for (int i = 0; i < 10; i++) {
                FibonacciCalculator calculator = new FibonacciCalculator(i);
                threadPool.execute(calculator);
            }
        }
    }
}
