package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {

    private Task8() {

    }

    public static Optional<Animal> findHeaviestAnimalBelowHeight(List<Animal> animals, int heightLimit) {
        return animals.stream()
            .filter(animal -> animal.height() < heightLimit)
            .max(Comparator.comparingInt(Animal::weight));
    }
}
