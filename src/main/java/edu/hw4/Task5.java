package edu.hw4;

import java.util.List;

public class Task5 {

    private Task5() {

    }

    public static Animal.Sex countAnimalsBySex(List<Animal> animals) {
        int malesCount = countBySex(animals, Animal.Sex.M);
        int femalesCount = countBySex(animals, Animal.Sex.F);

        if (malesCount > femalesCount) {
            return Animal.Sex.M;
        } else if (malesCount < femalesCount) {
            return Animal.Sex.F;
        } else {
            return null;
        }
    }

    private static int countBySex(List<Animal> animals, Animal.Sex sex) {
        return (int) animals.stream()
            .filter(animal -> animal.sex() == sex)
            .count();
    }
}
