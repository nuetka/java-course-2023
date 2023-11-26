package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {

    @Test
    public void testLongestName() {
        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 2, 120, 55, true);
        Animal elephant = new Animal("Elephant", Animal.Type.FISH, Animal.Sex.F, 3, 300, 150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.FISH, Animal.Sex.M, 4, 540, 300, false);
        Animal zebra = new Animal("Zebra", Animal.Type.FISH, Animal.Sex.F, 5, 150, 200, false);

        List<Animal> animals1 = Arrays.asList(elephant, zebra);
        List<Animal> animals2 = Arrays.asList( lion, giraffe);
        List<Animal> animals3 = List.of(lion);


        assertThat(Task18.findHeaviestF(animals1,animals2,animals3)).isEqualTo(giraffe);
    }
}

