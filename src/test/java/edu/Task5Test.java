package edu;

import edu.hw1.Task5;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    public void testIsPalindromeDescendant() {
        assertThat(Task5.isPalindromeDescendant(11211230)).isTrue();
        assertThat(Task5.isPalindromeDescendant(13001120)).isTrue();
        assertThat(Task5.isPalindromeDescendant(23336014)).isTrue();
        assertThat(Task5.isPalindromeDescendant(11)).isTrue();
        assertThat(Task5.isPalindromeDescendant(123456)).isFalse();
    }

    @Test
    public void testOddNumber() {
        assertThat(Task5.isPalindromeDescendant(12321)).isTrue();
        assertThat(Task5.isPalindromeDescendant(1234566)).isFalse();
        assertThat(Task5.isPalindromeDescendant(888)).isTrue();
    }

    @Test
    public void testNegative() {
        assertThat(Task5.isPalindromeDescendant(-11)).isFalse();
        assertThat(Task5.isPalindromeDescendant(-123456)).isFalse();
    }

    @Test
    public void testOneNumber() {
        assertThat(Task5.isPalindromeDescendant(1)).isTrue();
    }


}
