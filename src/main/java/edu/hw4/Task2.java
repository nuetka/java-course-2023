package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task2 {

    private Task2() {

    }

    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {

        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

}
