package com.in28minutes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    private final MyMath myMath = new MyMath();
    @Test
    void calculateSum_ThreeLengthArray() {
        assertEquals(6, myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        assertEquals(0, myMath.calculateSum(new int[]{}));
    }
}