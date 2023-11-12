package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task14Test {
    @Test
    public void testTrue() {

        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephant dfgdfg", Animal.Type.DOG, Animal.Sex.F, 3, 300, 1150, true);
        Animal giraffe = new Animal("Giraffe dfg dfg ", Animal.Type.BIRD, Animal.Sex.M, 2, 540, 300, false);
        Animal zebra = new Animal("Zebrad dfg dfg dfg", Animal.Type.FISH, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        int k=12;

        assertThat(Task14.isDogTallerThan(animals,k)).isTrue();
    }
    @Test
    public void testFalse() {

        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 120, 55, true);
        Animal elephant = new Animal("Elephant dfgdfg", Animal.Type.BIRD, Animal.Sex.F, 3, 300, 1150, true);
        Animal giraffe = new Animal("Giraffe dfg dfg ", Animal.Type.DOG, Animal.Sex.M, 2, 5, 300, false);
        Animal zebra = new Animal("Zebrad dfg dfg dfg", Animal.Type.FISH, Animal.Sex.F, 5, 15, 200, true);

        List<Animal> animals = Arrays.asList(elephant, zebra, lion, giraffe);

        int k=34;



        assertThat(Task14.isDogTallerThan(animals,k)).isFalse();
    }
}
