package edu.hw9.Task1;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.extern.java.Log;

public class Main {

    private Main() {

    }

    @Log
    public static void main(String[] args) {
        StatsCollector collector = new StatsCollector();
        collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        collector.push("metric2", new double[] {2.0, 1.5, 3.4, 0.8, 1.2});

        try {
            Map<String, StatsResult> stats = collector.getStats();

            for (Map.Entry<String, StatsResult> entry : stats.entrySet()) {
                String metricName = entry.getKey();
                StatsResult statsResult = entry.getValue();

                System.out.println("Metric: " + metricName);
                System.out.println("Sum: " + statsResult.getSum());
                System.out.println("Average: " + statsResult.getAverage());
                System.out.println("Min: " + statsResult.getMin());
                System.out.println("Max: " + statsResult.getMax());
                System.out.println();
            }
        } catch (InterruptedException | ExecutionException e) {
            log.severe("Something's wrong here");
        } finally {
            collector.shutdown();
        }
    }
}
