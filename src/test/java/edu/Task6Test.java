package edu;

import edu.hw1.Task6;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @ParameterizedTest
    @ValueSource(ints = {352467, 0})
    public void testIncorrectData(int input) {
        assertEquals(-1, Task6.countK(input));
    }

    @ParameterizedTest
    @CsvSource({
        "3524, 3",
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "6174, 0"
    })
    void countSteps(int input, int expected) {
        assertEquals(expected, Task6.countK(input));
    }

}
