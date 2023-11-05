package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static edu.hw4.Task3.countAnimalsByType;
import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task6Test {
    @Test
    public void testFind() {


        Animal cat1 = new Animal("Кот", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, true);
        Animal cat2 = new Animal("Барсик", Animal.Type.CAT, Animal.Sex.F, 3, 50, 10, true);
        Animal bird1 = new Animal("Попугай", Animal.Type.BIRD, Animal.Sex.M, 4, 40, 23, false);
        Animal bird2 = new Animal("Орел", Animal.Type.BIRD, Animal.Sex.M, 5, 80, 10, false);
        Animal sp = new Animal("О", Animal.Type.SPIDER, Animal.Sex.M, 5, 80, 10, false);

        List<Animal> animals = Arrays.asList(cat1,cat2,bird1,bird2,sp);

        Map<Animal.Type, Animal> heaviestAnimalsByType = Task6.findHeaviestAnimalsByType(animals);


        assertThat(heaviestAnimalsByType).containsExactly(
            entry(Animal.Type.CAT, cat2),
            entry(Animal.Type.SPIDER, sp),
            entry(Animal.Type.BIRD, bird1)
        );
    }
}
