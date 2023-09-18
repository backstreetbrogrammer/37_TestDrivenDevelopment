package com.backstreetbrogrammer.model;

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
}
