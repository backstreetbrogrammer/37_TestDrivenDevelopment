package com.backstreetbrogrammer.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void groupedAssertions() {
        // given
        final Student student = new Student(1L, "John", "Wright");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals("John", student.getFirstName()),
                  () -> assertEquals("Wright", student.getLastName())
                 );
    }

    @Test
    void groupedAssertionsWithMessage() {
        // given
        final Student student = new Student(1L, "John", "Wright");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals("John", student.getFirstName(), "First Name Failed"),
                  () -> assertEquals("Wright", student.getLastName(), "Last Name Failed")
                 );
    }

    @Test
    void testExpectedExceptions() {
        assertThrows(IllegalArgumentException.class,
                     () -> new Student(-1L, "Unknown", "Student"));
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            System.out.println("Running the timeout test");
            TimeUnit.MILLISECONDS.sleep(80L);
        });
    }

    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            System.out.println("Running the timeout test preemptively");
            TimeUnit.MILLISECONDS.sleep(80L);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Advanced", "Java", "Course"})
    void testValueSource(final String val) {
        System.out.println(val);
    }
}
