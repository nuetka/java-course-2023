package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @ParameterizedTest
    @CsvSource({
        "2, II",
        "12, XII",
        "16, XVI"
    })
    public void testConvertToRoman(int number, String expectedRoman) {
        String actualRoman = Task4.convertToRoman(number);
        assertThat(actualRoman).isEqualTo(expectedRoman);
    }
}
