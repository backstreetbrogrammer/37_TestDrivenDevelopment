package com.backstreetbrogrammer.ch03_mockito;

import com.backstreetbrogrammer.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentsRepository {

    private final Map<Long, Student> cache = new HashMap<>();

    public Student save(final Student student) {
        return cache.put(student.getId(), student);
    }

    public Student findById(final Long id) {
        return cache.get(id);
    }

    public Student deleteById(final Long id) {
        return cache.remove(id);
    }

    public Student delete(final Student student) {
        return cache.remove(student.getId());
    }

}
