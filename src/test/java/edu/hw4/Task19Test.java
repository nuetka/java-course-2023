package edu.hw4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.hw4.Task19.validateAnimal;
import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task19Test {
    @Test
    public void testAnimalValidation() {
        Animal cat = new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, -2, 30, 5, false);
        Animal dog = new Animal("Fido", Animal.Type.DOG, Animal.Sex.M, 4, 60, 25, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.F, 1, 10, 1, false);
        Animal spider = new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 0, false);

        List<Animal> animals = Arrays.asList(cat, dog, fish, spider);
        Map<String, Set<ValidationError>> animalErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = validateAnimal(animal);
            if (!errors.isEmpty()) {
                animalErrors.put(animal.name(), errors);
            }
        }

        // Проверяем, что ошибки обнаружены корректно
        Assertions.assertThat(animalErrors).containsOnlyKeys("Whiskers", "Charlotte");

        // Проверяем конкретные ошибки для каждого животного
        Assertions.assertThat(animalErrors.get("Whiskers")).containsExactly(
            new ValidationError("age", "Age must be greater than or equal to 0")
        );

        Assertions.assertThat(animalErrors.get("Charlotte")).containsExactly(
            new ValidationError("weight", "Weight must be greater than or equal to 0")
        );
    }

    @Test
    public void testTask20() {
        Animal cat = new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, -2, 30, 5, false);
        Animal dog = new Animal("Fido", Animal.Type.DOG, Animal.Sex.M, 4, 60, 25, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.F, 1, 10, 1, false);
        Animal spider = new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 0, false);

        List<Animal> animals = Arrays.asList(cat, dog, fish, spider);
        Map<String, Set<ValidationError>> animalErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = validateAnimal(animal);
            if (!errors.isEmpty()) {
                animalErrors.put(animal.name(), errors);
            }
        }
        assertThat(Task19.formatValidationResults(animalErrors)).containsExactly(
            entry("Charlotte", "weight: Weight must be greater than or equal to 0"),
            entry( "Whiskers","age: Age must be greater than or equal to 0")
        );

    }

}
