package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {

    }

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> animalCounts = new HashMap<>();

        for (Animal animal : animals) {
            Animal.Type type = animal.type();
            animalCounts.put(type, animalCounts.getOrDefault(type, 0) + 1);
        }

        return animalCounts;
    }
}
