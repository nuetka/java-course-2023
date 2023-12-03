package edu.hw4;

import java.util.List;

public class Task4 {

    private Task4() {

    }

    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        if (animals.isEmpty()) {
            return null;
        }

        Animal animalWithLongestName = animals.get(0);
        for (Animal animal : animals) {
            if (animal.name().length() > animalWithLongestName.name().length()) {
                animalWithLongestName = animal;
            }
        }

        return animalWithLongestName;
    }
}
