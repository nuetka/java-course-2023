package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {

    private Task19() {

    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.age() <= 0) {
            errors.add(new ValidationError("age", "Age must be greater than or equal to 0"));
        }

        if (animal.height() <= 0) {
            errors.add(new ValidationError("height", "Height must be greater than or equal to 0"));
        }

        if (animal.weight() <= 0) {
            errors.add(new ValidationError("weight", "Weight must be greater than or equal to 0"));
        }

        return errors;
    }

    public static Map<String, String> formatValidationResults(Map<String, Set<ValidationError>> validationResults) {
        Map<String, String> formattedResults = new HashMap<>();

        for (Map.Entry<String, Set<ValidationError>> entry : validationResults.entrySet()) {
            String name = entry.getKey();
            Set<ValidationError> errors = entry.getValue();

            List<String> errorMessages = new ArrayList<>();
            for (ValidationError error : errors) {
                errorMessages.add(error.getField() + ": " + error.getMessage());
            }

            String formattedErrorString = String.join(", ", errorMessages);
            formattedResults.put(name, formattedErrorString);
        }

        return formattedResults;
    }
}
