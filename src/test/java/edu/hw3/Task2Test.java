package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testEmptyString() {
        String input = "";
        List<String> result = Task2.clusterize(input);
        assertEquals(0, result.size());
    }

    @Test
    public void testSingleParentheses() {
        String input = "()()()";
        List<String> result = Task2.clusterize(input);
        assertEquals(3, result.size());
        assertEquals("()", result.get(0));
        assertEquals("()", result.get(1));
        assertEquals("()", result.get(2));
    }

    @Test
    public void testNoChange() {
        String input = "((()))";
        List<String> result = Task2.clusterize(input);
        assertEquals(1, result.size());
        assertEquals("((()))", result.get(0));
    }

    @Test
    public void testEmptyAndNotEmptyInside() {
        String input = "((()))(())()()(()())";
        List<String> result = Task2.clusterize(input);
        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(())", result.get(1));
        assertEquals("()", result.get(2));
        assertEquals("()", result.get(3));
        assertEquals("(()())", result.get(4));
    }

    @Test
    public void testNotEmptyInside() {
        String input = "((())())(()(()()))";
        List<String> result = Task2.clusterize(input);
        assertEquals(2, result.size());
        assertEquals("((())())", result.get(0));
        assertEquals("(()(()()))", result.get(1));
    }

}
