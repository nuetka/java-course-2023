package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {

    @Test
    public void testCount() {
        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 2, 120, 55, true);
        Animal elephant = new Animal("Elephant", Animal.Type.BIRD, Animal.Sex.M, 3, 300, 150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.BIRD, Animal.Sex.M, 4, 540, 300, false);
        Animal zebra = new Animal("Zebra", Animal.Type.FISH, Animal.Sex.F, 5, 150, 200, false);

        int k=300;
        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        assertThat(Task9.calculateSumOfPaws(animals)).isEqualTo(8);
    }
}
