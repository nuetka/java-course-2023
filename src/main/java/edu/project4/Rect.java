package edu.project4;

class Rect {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    Rect(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Point p) {
        return p.x() >= x && p.x() <= x + width && p.y() >= y && p.y() <= y + height;
    }

    public double x() {
        return x;
    }

    public double y() {
        return x;
    }

    public double width() {
        return x;
    }

    public double height() {
        return x;
    }

}
