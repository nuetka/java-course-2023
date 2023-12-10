package edu.project4;

import java.util.Arrays;

class FractalImage {
    private final Pixel[] data;
    private final int width;
    private final int height;

    FractalImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new Pixel[width * height];
        Arrays.fill(data, new Pixel(0, 0, 0, 0));
    }

    public synchronized void blendPixel(double x, double y, Pixel pixel) {
        int index = (int) (y * width + x);
        Pixel current = data[index];
        data[index] = new Pixel(
            current.r() + pixel.r(),
            current.g() + pixel.g(),
            current.b() + pixel.b(),
            current.hitCount() + 1
        );
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel pixel(int x, int y) {
        return data[y * width + x];
    }

    public Pixel[] data() {
        return data;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
