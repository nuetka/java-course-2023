package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {

    private Task7() {

    }

    public static Animal findKthOldestAnimal(List<Animal> animals, int k) {
        if (k <= 0 || k > animals.size()) {
            return null;
        }

        List<Animal> sortedAnimals = animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .collect(Collectors.toList());

        return sortedAnimals.get(k - 1);
    }
}
