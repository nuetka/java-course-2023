package edu.hw4;

import java.util.List;

public class Task18 {

    private Task18() {

    }

    public static Animal findHeaviestF(List<Animal>... lists) {
        Animal heaviestFish = null;
        int maxWeight = Integer.MIN_VALUE;

        for (List<Animal> list : lists) {
            for (Animal animal : list) {
                if (animal.type() == Animal.Type.FISH && animal.weight() > maxWeight) {
                    maxWeight = animal.weight();
                    heaviestFish = animal;
                }
            }
        }

        return heaviestFish;
    }
}
