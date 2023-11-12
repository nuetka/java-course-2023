package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void test1925() {
        List<LocalDate> expectedDates = Arrays.asList(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        );

        List<LocalDate> actualDates = Task2.findFriday13s(1925);

        assertEquals(expectedDates, actualDates);
    }

    @Test
    public void test2024() {
        List<LocalDate> expectedDates = Arrays.asList(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        );

        List<LocalDate> actualDates = Task2.findFriday13s(2024);

        assertEquals(expectedDates, actualDates);
    }

    @Test
    public void testNextFriday() {
       LocalDate expectedDate = LocalDate.of(2024, 9, 13);
        assertEquals(expectedDate, Task2.findNextFriday13(LocalDate.of(2024, 8, 13)));
    }
}
