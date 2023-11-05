package edu.hw4;

import java.util.List;

public class Task14 {

    private Task14() {

    }

    public static boolean isDogTallerThan(List<Animal> animals, int k) {
        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.DOG && animal.height() > k) {
                return true;
            }
        }
        return false;
    }
}
