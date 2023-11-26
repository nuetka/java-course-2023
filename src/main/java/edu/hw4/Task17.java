package edu.hw4;

import java.util.List;

public class Task17 {

    private Task17() {

    }

    public static boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        int spiderBites = 0;
        int spiderNotBites = 0;
        int dogBites = 0;
        int dogNotBites = 0;

        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.SPIDER && animal.bites()) {
                spiderBites++;
            } else if (animal.type() == Animal.Type.DOG && animal.bites()) {
                dogBites++;
            } else if (animal.type() == Animal.Type.SPIDER) {
                spiderNotBites++;
            } else if (animal.type() == Animal.Type.DOG) {
                dogNotBites++;
            }
        }

        if (spiderBites + spiderNotBites > 0 && dogBites + dogNotBites > 0) {
            return spiderBites / (spiderBites + spiderNotBites) > dogBites / (dogBites + dogNotBites);
        } else {
            return false;
        }
    }
}
