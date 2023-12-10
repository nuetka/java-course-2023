package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class StatsCollector {
    private final Map<String, BlockingQueue<Double>> dataMap;
    private final ExecutorService executorService;

    @SuppressWarnings("MagicNumber")
    public StatsCollector() {
        this.dataMap = new HashMap<>();
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void push(String metricName, double[] data) {
        List<Double> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());
        dataMap.computeIfAbsent(metricName, k -> new LinkedBlockingQueue<>()).addAll(dataList);
    }

    public Map<String, StatsResult> getStats() throws InterruptedException, ExecutionException {
        Map<String, StatsResult> result = new HashMap<>();
        List<Future<?>> futures = new ArrayList<>();
        for (Map.Entry<String, BlockingQueue<Double>> entry : dataMap.entrySet()) {
            String metricName = entry.getKey();
            BlockingQueue<Double> dataQueue = entry.getValue();
            Callable<Void> callable = () -> {
                double sum = 0;
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;
                while (!dataQueue.isEmpty()) {
                    double value = dataQueue.poll();
                    sum += value;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }
                double average = sum / (dataQueue.size() + 1);
                StatsResult statsResult = new StatsResult(sum, average, min, max);
                result.put(metricName, statsResult);
                return null;
            };
            futures.add(executorService.submit(callable));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        return result;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
