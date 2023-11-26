package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 {

    private Task11() {

    }

    public static List<Animal> findAnimals(List<Animal> animals) {
        final int HUNDERT = 100;
        List<Animal> bitingAnimalsWithHeightGreaterThan100 = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.bites() && animal.height() > HUNDERT) {
                bitingAnimalsWithHeightGreaterThan100.add(animal);
            }
        }
        return bitingAnimalsWithHeightGreaterThan100;
    }
}
