package edu.hw9.Task1;

public class StatsResult {
    private final double sum;
    private final double average;
    private final double min;
    private final double max;

    public StatsResult(double sum, double average, double min, double max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    double getSum() {
        return sum;
    }

    double getAverage() {
        return average;
    }

    double getMin() {
        return min;
    }

    double getMax() {
        return max;
    }

}
