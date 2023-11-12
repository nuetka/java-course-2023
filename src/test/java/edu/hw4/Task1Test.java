package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task1Test {

    @Test
    public void testSortAnimalsByHeight() {
        // Создаем неотсортированный список животных
        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 2, 120, 55, true);
        Animal elephant = new Animal("Elephant", Animal.Type.BIRD, Animal.Sex.F, 3, 300, 150, false);
        Animal giraffe = new Animal("Giraffe", Animal.Type.BIRD, Animal.Sex.M, 4, 540, 300, false);
        Animal zebra = new Animal("Zebra", Animal.Type.FISH, Animal.Sex.F, 5, 150, 200, false);

        List<Animal> unsortedAnimals = Arrays.asList(elephant, zebra, lion, giraffe);

        // Сортируем список
        List<Animal> sortedAnimals = Task1.sortAnimalsByHeight(unsortedAnimals);

        // Проверяем, что список отсортирован правильно
        assertThat(sortedAnimals).containsExactly(lion, zebra, elephant, giraffe);
    }
}
