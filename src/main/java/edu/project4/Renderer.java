package edu.project4;

import java.util.List;

public interface Renderer {
    FractalImage render(FractalImage canvas, Rect world, List<Transformation> variations,
        int samples, short iterPerSample, int symmetry, long seed);
}
