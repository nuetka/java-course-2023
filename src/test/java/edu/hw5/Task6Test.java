package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {

    @Test
    public void testYes() {
        assertTrue(Task6.isSubsequence("abc","achfdbaabgabcaabg" ));
    }

    @Test
    public void testNo() {
        assertFalse(Task6.isSubsequence("abc","cabjkj" ));
    }
}
