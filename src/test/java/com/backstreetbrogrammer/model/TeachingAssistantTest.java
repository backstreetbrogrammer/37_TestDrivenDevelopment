package com.backstreetbrogrammer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeachingAssistantTest {

    @Test
    void dependentAssertions() {
        // given
        final TeachingAssistant teachingAssistant
                = new TeachingAssistant(2L, "Mary", "Lam", "Advanced Java", 21);

        // then
        assertAll("Students Test",
                  () -> assertAll("Student Properties",
                                  () -> assertEquals("Mary", teachingAssistant.getFirstName(),
                                                     "First Name did not match"),
                                  () -> assertEquals("Lam", teachingAssistant.getLastName())),
                  () -> assertAll("TeachingAssistant Properties",
                                  () -> assertEquals("Advanced Java", teachingAssistant.getCourseToAssist(),
                                                     "Course did not match"),
                                  () -> assertEquals(21, teachingAssistant.getAge()))
                 );
    }

}
