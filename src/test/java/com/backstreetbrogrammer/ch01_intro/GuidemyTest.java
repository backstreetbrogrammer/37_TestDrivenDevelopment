package com.backstreetbrogrammer.ch01_intro;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GuidemyTest {

    Guidemy guidemy;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am called once!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        guidemy = new Guidemy();
    }

    @Test
    @DisplayName("Test that object is not null after setUp()")
    void testObjectNotNull() {
        assertNotNull(guidemy);
    }

    @Test
    @DisplayName("Test getting current course name")
    void testGetCourseMethod() {
        assertEquals("Advanced Java", guidemy.getCourse());
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After - I am called once!");
    }
}
