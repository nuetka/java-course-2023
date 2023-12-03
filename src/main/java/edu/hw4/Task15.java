package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {

    private Task15() {

    }

    public static Map<Animal.Type, Integer> calculateTotalWeightByAgeRange(List<Animal> animals, int k, int l) {
        Map<Animal.Type, Integer> totalWeightByType = new HashMap<>();

        for (Animal animal : animals) {
            int age = animal.age();
            if (age >= k && age <= l) {
                Animal.Type type = animal.type();
                int currentWeight = totalWeightByType.getOrDefault(type, 0);
                totalWeightByType.put(type, currentWeight + animal.weight());
            }
        }

        return totalWeightByType;
    }
}
