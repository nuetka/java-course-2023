package edu.project4;

class Pixel {
    private final int r;
    private final int g;
    private final int b;
    private final int hitCount;

    Pixel(int r, int g, int b, int hitCount) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.hitCount = hitCount;
    }

    public int hitCount() {
        return hitCount;
    }

    public int b() {
        return b;
    }

    public int g() {
        return g;
    }

    public int r() {
        return r;
    }
}
