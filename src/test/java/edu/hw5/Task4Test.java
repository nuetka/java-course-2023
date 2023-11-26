package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    public void testYes() {
        assertTrue(Task4.contains("example@123"));
    }

    @Test
    public void testNo() {
        assertFalse(Task4.contains("example123"));
    }
}
