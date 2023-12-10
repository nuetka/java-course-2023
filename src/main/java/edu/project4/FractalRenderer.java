package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.java.Log;

@Log
class FractalRenderer implements Renderer {
    private final ExecutorService executorService;

    FractalRenderer(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    @Override
    public FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterPerSample,
        int symmetry,
        long seed
    ) {
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int num = 0; num < samples; ++num) {
            final Point pw = random(world, seed + num);

            tasks.add(() -> {
                for (short step = 0; step < iterPerSample; ++step) {
                    Transformation variation = random(variations, seed + step);

                    Point pwTransformed = variation.apply(pw);

                    double theta2 = 0.0;
                    for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                        Point pwr = rotate(pwTransformed, theta2);
                        if (!world.contains(pwr)) {
                            continue;
                        }

                        Pixel pixel = mapRANGE(world, pwr, canvas);
                        if (pixel == null) {
                            continue;
                        }

                        synchronized (canvas) {
                            canvas.blendPixel(pwr.x(), pwr.y(), pixel);
                        }
                    }
                }
                return null;
            });
        }

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            log.severe("Ups");
        } finally {
            executorService.shutdown();
        }

        return canvas;
    }

    private static Point random(Rect rect, long seed) {
        Random random = new Random(seed);
        double x = rect.x() + random.nextDouble() * rect.width();
        double y = rect.y() + random.nextDouble() * rect.height();
        return new Point(x, y);
    }

    private static Transformation random(List<Transformation> variations, long seed) {
        Random random = new Random(seed);
        return variations.get(random.nextInt(variations.size()));
    }

    private static Point rotate(Point point, double angle) {
        double x = point.x() * Math.cos(angle) - point.y() * Math.sin(angle);
        double y = point.x() * Math.sin(angle) + point.y() * Math.cos(angle);
        return new Point(x, y);
    }

    private static Pixel mapRANGE(Rect world, Point point, FractalImage canvas) {
        int x = (int) Math.floor(canvas.width() * (point.x() - world.x()) / world.width());
        int y = (int) Math.floor(canvas.height() * (point.y() - world.y()) / world.height());

        if (!canvas.contains(x, y)) {
            return null;
        }

        return canvas.pixel(x, y);
    }
}


