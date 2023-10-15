package edu;

import edu.hw1.Task3;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    public void testNestableArrays1() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};
        assertThat(Task3.isNestable(arr1, arr2)).isTrue();
    }

    @Test
    public void testNestableArrays2() {
        int[] arr1 = {3, 1};
        int[] arr2 = {4, 0};
        assertThat(Task3.isNestable(arr1, arr2)).isTrue();
    }

    @Test
    public void testNestableArrays3() {
        int[] arr1 = {9, 9, 8};
        int[] arr2 = {8, 9};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }

    @Test
    public void testNestableArrays4() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }

    @Test
    public void testEmptyArrays() {
        int[] arr1 = {};
        int[] arr2 = {};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }

    @Test
    public void testEmptyFirstArray() {
        int[] arr1 = {};
        int[] arr2 = {1, 2, 3};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }

    @Test
    public void testEmptySecondArray() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }
}
