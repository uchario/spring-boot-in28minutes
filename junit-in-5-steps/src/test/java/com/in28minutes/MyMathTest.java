package com.in28minutes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    private final MyMath myMath = new MyMath();
    private final List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void calculateSum_ThreeLengthArray() {
        assertEquals(6, myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        assertEquals(0, myMath.calculateSum(new int[]{}));
    }

    @Test
    void isPresentInList() {
        assertTrue(todos.contains("AWS"));
    }

    @Test
    void isAbsentInList() {
        assertFalse(todos.contains("GCP"));
    }
}