package edu;

import edu.hw1.Task5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void testIsPalindromeDescendant() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(11));
        assertFalse(Task5.isPalindromeDescendant(123456));
    }

    @Test
    public void testOddNumber() {
        assertTrue(Task5.isPalindromeDescendant(12321));
        assertFalse(Task5.isPalindromeDescendant(1234566));
        assertTrue(Task5.isPalindromeDescendant(888));
    }

    @Test
    public void testNegative() {
        assertFalse(Task5.isPalindromeDescendant(-11));
        assertFalse(Task5.isPalindromeDescendant(-123456));
    }

    @Test
    public void testOneNumber() {
        assertTrue(Task5.isPalindromeDescendant(1));
    }

}
