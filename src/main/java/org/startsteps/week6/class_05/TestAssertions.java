package org.startsteps.week6.class_05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAssertions {
    // JUnit is a popular Java testing framework that helps developers write and run
    // tests to ensure the quality and
    // correctness of their code. It provides various features to facilitate testing,
    // including setup and teardown
    // methods, as well as the ability to handle exceptions.

    @BeforeEach
    public void setUp() {
        System.out.println("Before test method");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After test method");
    }



    @Test
    @DisplayName("test assertions")
    void testAssertions() {

        // given
        String str1 = "abc";
        String str2 = "abc";
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray =  {"one", "two", "three"};

        List<String> expectedList = Arrays.asList("apple", "banana", "cherry");
        List<String> actualList = Arrays.asList("apple", "banana", "cherry");

        // when
        //        Assertion assert = new Assetion();
        //        assert.method();
        // then
        assertEquals(str1, str2);

        assertTrue(val1 < val2);

        assertFalse(val1 > val2);

        assertNotNull(str1);

        assertNull(str3);

        assertNotSame(str1, str3);

        assertSame(str4, str5);

        assertArrayEquals(expectedArray, resultArray);

        System.out.println("Test method");
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 5 / 0;
        });
    }



}
