package com.backstreetbrogrammer.model;

public class TeachingAssistant extends Student {
    private final String courseToAssist;
    private final int age;

    public TeachingAssistant(final long id, final String firstName,
                             final String lastName, final String courseToAssist, final int age) {
        super(id, firstName, lastName);
        this.courseToAssist = courseToAssist;
        this.age = age;
    }

    public String getCourseToAssist() {
        return courseToAssist;
    }

    public int getAge() {
        return age;
    }
}
