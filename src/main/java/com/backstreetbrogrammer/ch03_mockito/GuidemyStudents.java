package com.backstreetbrogrammer.ch03_mockito;

import com.backstreetbrogrammer.model.Student;

public class GuidemyStudents {

    private final StudentsRepository repository;

    public GuidemyStudents(final StudentsRepository repository) {
        this.repository = repository;
    }

    public Student deleteById(final Long id) {
        return repository.deleteById(id);
    }

    public Student delete(final Student student) {
        return repository.delete(student);
    }

    public Student find(final Student student) {
        return repository.findById(student.getId());
    }

}
