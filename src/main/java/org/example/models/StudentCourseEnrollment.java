package org.example.models;

import java.util.List;

public record StudentCourseEnrollment(
        Student s,
        List<String> courseIDs
) {
}
