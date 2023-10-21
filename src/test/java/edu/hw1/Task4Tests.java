package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Tests {

    @Test
    void shouldFixStringCorrectly() {
        String test1 = "123456";
        String expected1 = "214365";

        String test2 = "hTsii  s aimex dpus rtni.g";
        String expected2 = "This is a mixed up string.";

        String test3 = "badce";
        String expected3 = "abcde";

        assertThat(Task4.fixString(test1)).isEqualTo(expected1);
        assertThat(Task4.fixString(test2)).isEqualTo(expected2);
        assertThat(Task4.fixString(test3)).isEqualTo(expected3);
    }

    @Test
    void shouldHandleEmptyStringCorrectly() {
        String test = "";
        String expected = "";

        assertThat(Task4.fixString(test)).isEqualTo(expected);
    }

    @Test
    void shouldHandleSingleCharacterStringCorrectly() {
        String test = "a";
        String expected = "a";

        assertThat(Task4.fixString(test)).isEqualTo(expected);
    }
}
