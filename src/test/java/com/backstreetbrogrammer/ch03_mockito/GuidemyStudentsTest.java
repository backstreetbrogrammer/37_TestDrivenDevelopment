package com.backstreetbrogrammer.ch03_mockito;

import com.backstreetbrogrammer.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GuidemyStudentsTest {

    @Mock
    StudentsRepository repository;

    @InjectMocks
    GuidemyStudents guidemyStudents;

    @Test
    void testDeleteById() {
        // given - none

        // when
        guidemyStudents.deleteById(1L);
        guidemyStudents.deleteById(1L);

        // then
        verify(repository, times(2)).deleteById(1L);
        verify(repository, atLeastOnce()).deleteById(1L);
        verify(repository, atMost(5)).deleteById(1L);
        verify(repository, never()).deleteById(3L);
    }

    @Test
    void testDelete() {
        // given
        final Student student = new Student(1L, "John", "Wright");

        // when
        guidemyStudents.delete(student);

        // then
        verify(repository).delete(any(Student.class));
    }

    @Test
    void testFindStudentById() {
        // given
        final Student student = new Student(1L, "John", "Wright");

        // when
        when(repository.findById(1L)).thenReturn(student);
        final Student studentFromRepo = repository.findById(1L);

        // then
        assertNotNull(studentFromRepo);
        assertTrue(student.equals(studentFromRepo));

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testArgumentCaptor() {
        // given
        final Student student = new Student(1L, "John", "Wright");
        final ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

        // when
        guidemyStudents.find(student);

        // then
        verify(repository).findById(captor.capture());
        assertEquals(1L, captor.getValue());
    }
}
