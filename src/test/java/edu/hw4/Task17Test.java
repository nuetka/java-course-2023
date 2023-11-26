package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task17Test {
    @Test
    public void testTrue() {

        Animal lion = new Animal("Lion", Animal.Type.DOG, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephan", Animal.Type.DOG, Animal.Sex.F, 3, 300, 1150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.SPIDER, Animal.Sex.M, 2, 540, 300, true);
        Animal zebra = new Animal("Zebrad", Animal.Type.SPIDER, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        assertThat(Task17.doSpidersBiteMoreThanDogs(animals)).isTrue();
    }

    @Test
    public void testFalse() {

        Animal lion = new Animal("Lion", Animal.Type.DOG, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephan", Animal.Type.DOG, Animal.Sex.F, 3, 300, 1150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.SPIDER, Animal.Sex.M, 2, 540, 300, false);
        Animal zebra = new Animal("Zebrad", Animal.Type.SPIDER, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        assertThat(Task17.doSpidersBiteMoreThanDogs(animals)).isFalse();
    }

    @Test
    public void testNotDataEnough() {

        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephan", Animal.Type.BIRD, Animal.Sex.F, 3, 300, 1150, true);
        Animal giraffe = new Animal("Giraffe", Animal.Type.BIRD, Animal.Sex.M, 2, 540, 300, false);
        Animal zebra = new Animal("Zebrad", Animal.Type.FISH, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);



        assertThat(Task17.doSpidersBiteMoreThanDogs(animals)).isFalse();
    }

}
