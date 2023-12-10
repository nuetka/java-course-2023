package edu.hw9.Task1;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.extern.java.Log;

@Log
public class Main {

    private Main() {

    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        StatsCollector collector = new StatsCollector();
        collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        collector.push("metric2", new double[] {2.0, 1.5, 3.4, 0.8, 1.2});

        try {
            Map<String, StatsResult> stats = collector.getStats();

            for (Map.Entry<String, StatsResult> entry : stats.entrySet()) {
                String metricName = entry.getKey();
                StatsResult statsResult = entry.getValue();

                log.info("Metric: " + metricName);
                log.info("Sum: " + statsResult.getSum());
                log.info("Average: " + statsResult.getAverage());
                log.info("Min: " + statsResult.getMin());
                log.info("Max: " + statsResult.getMax());
                log.info("\n");
            }
        } catch (InterruptedException | ExecutionException e) {
            log.severe("Something's wrong here");

        } finally {
            collector.shutdown();
        }
    }
}
