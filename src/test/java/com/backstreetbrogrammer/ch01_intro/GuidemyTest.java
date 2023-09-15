package com.backstreetbrogrammer.ch01_intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuidemyTest {

    @Test
    void testGetCourseMethod() {
        final Guidemy guidemy = new Guidemy();
        assertEquals("Advanced Java", guidemy.getCourse());
    }
}
