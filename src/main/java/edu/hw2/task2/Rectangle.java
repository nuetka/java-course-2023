package edu.hw2.task2;

public class Rectangle {
    protected int width;
    protected int height;

    public final void setWidth(int width) {
        this.width = width;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }

}
