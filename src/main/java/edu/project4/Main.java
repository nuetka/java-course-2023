package edu.project4;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Main {

    private Main() {

    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;

        FractalImage fractalImage = new FractalImage(width, height);
        Renderer renderer = new FractalRenderer(4);

        Rect world = new Rect(-2.0, -2.0, 4.0, 4.0);
        List<Transformation> variations = Arrays.asList(
            new Transformation(0.5, 0.5),
            new Transformation(-0.5, 0.5)
        );

        int samples = 10000;
        short iterPerSample = 50;
        int symmetry = 3;
        long seed = System.currentTimeMillis();

        fractalImage = renderer.render(fractalImage, world, variations, samples, iterPerSample, symmetry, seed);

        double maxHitCount = getMaxHitCount(fractalImage);
        scalePixelValues(fractalImage, maxHitCount);

        ImageUtils.save(fractalImage, Paths.get("fractal_image.png"), ImageFormat.PNG);
    }

    private static double getMaxHitCount(FractalImage image) {
        double maxHitCount = Double.MIN_VALUE;
        for (Pixel pixel : image.data()) {
            maxHitCount = Math.max(maxHitCount, pixel.hitCount());
        }
        return maxHitCount;
    }

    private static void scalePixelValues(FractalImage image, double maxHitCount) {
        for (int i = 0; i < image.data().length; i++) {
            Pixel pixel = image.data()[i];
            int scaledR = (int) (255 * (pixel.r() / maxHitCount));
            int scaledG = (int) (255 * (pixel.g() / maxHitCount));
            int scaledB = (int) (255 * (pixel.b() / maxHitCount));
            image.data()[i] = new Pixel(scaledR, scaledG, scaledB, pixel.hitCount());
        }
    }
}
