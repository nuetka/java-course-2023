package edu.project4;

import java.util.function.Function;

class Transformation implements Function<Point, Point> {
    private final double offsetX;
    private final double offsetY;

    Transformation(double offsetX, double offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public Point apply(Point input) {
        double transformedX = input.x() + offsetX;
        double transformedY = input.y() + offsetY;
        return new Point(transformedX, transformedY);
    }
}
