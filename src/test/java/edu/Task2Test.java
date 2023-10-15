package edu;

import edu.hw1.Task2;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    public void testCountDigitsWithPositiveNumber() {
        int count = Task2.countDigits(4666);
        assertThat(count).isEqualTo(4);
    }

    @Test
    public void testCountDigitsWithZero() {
        int count = Task2.countDigits(0);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void testCountDigitsWithNegativeNumber() {
        int count = Task2.countDigits(-12345);
        assertThat(count).isEqualTo(5);
    }

    @Test
    public void testCountDigitsWithSingleDigitNumber() {
        int count = Task2.countDigits(7);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void testCountDigitsWithLargeNumber() {
        int count = Task2.countDigits(1234567890);
        assertThat(count).isEqualTo(10);
    }
}
