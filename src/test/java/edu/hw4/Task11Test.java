package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task11Test {

    @Test
    public void testFind() {

        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephant", Animal.Type.BIRD, Animal.Sex.F, 3, 300, 150, true);
        Animal giraffe = new Animal("Giraffe", Animal.Type.BIRD, Animal.Sex.M, 2, 540, 300, false);
        Animal zebra = new Animal("Zebra", Animal.Type.FISH, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);



        assertThat(Task11.findAnimals(animals)).containsExactly(elephant, lion);
    }
}
