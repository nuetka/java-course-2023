package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task1 {

    private Task1() {

    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        animals.sort(Comparator.comparingInt(Animal::height));
        return animals;
    }
}
