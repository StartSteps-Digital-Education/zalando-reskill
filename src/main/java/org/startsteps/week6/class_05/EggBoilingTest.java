package org.startsteps.week6.class_05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EggBoilingTest {
    EggBoiler eggBoiler;

    @BeforeEach
    public void setUp() {
        eggBoiler = new EggBoiler();
    }

    @Test
    public void testSoftBoiledEggIsReady() {
        boolean isReady = eggBoiler.isEggReady(4);
        assertTrue(isReady);
    }

    @Test
    public void testHardBoiledEggIsReady() {
        boolean isReady = eggBoiler.isEggReady(7);
        assertTrue(isReady);
    }

    @Test
    public void testEggNotReady() {
        boolean isReady = eggBoiler.isEggReady(2);
        assertFalse(isReady);
    }
}
