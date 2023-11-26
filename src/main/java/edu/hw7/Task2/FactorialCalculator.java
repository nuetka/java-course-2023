package edu.hw7.Task2;

import java.util.stream.LongStream;

public class FactorialCalculator {

    private FactorialCalculator() {

    }

    public static long factorial(int n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (long a, long b) -> a * b);
    }

    public static long run(int number) {
        return factorial(number);
    }
}
