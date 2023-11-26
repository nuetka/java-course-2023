package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    public void testFind() {
        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 2, 120, 55, true);
        Animal elephant = new Animal("Elephant", Animal.Type.BIRD, Animal.Sex.M, 3, 300, 150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.BIRD, Animal.Sex.M, 4, 540, 300, false);
        Animal zebra = new Animal("Zebra", Animal.Type.FISH, Animal.Sex.F, 5, 150, 200, false);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        int k=2;
        assertThat(Task7.findKthOldestAnimal(animals,k)).isEqualTo(giraffe);
    }



}