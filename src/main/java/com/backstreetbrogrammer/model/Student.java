package com.backstreetbrogrammer.model;

import java.util.Objects;

public class Student {

    private final long id;
    private final String firstName;
    private final String lastName;

    public Student(final long id, final String firstName, final String lastName) {
        if (id <= 0) throw new IllegalArgumentException("ID can not be 0 or negative");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
