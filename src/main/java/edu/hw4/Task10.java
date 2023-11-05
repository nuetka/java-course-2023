package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task10 {

    private Task10() {

    }

    public static List<Animal> findAnimals(List<Animal> animals) {
        List<Animal> animalsWithAgeMismatch = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.age() != animal.paws()) {
                animalsWithAgeMismatch.add(animal);
            }
        }
        return animalsWithAgeMismatch;
    }
}
