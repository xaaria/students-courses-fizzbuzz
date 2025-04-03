package org.example;

import org.example.models.Course;
import org.example.models.Student;
import org.example.models.StudentCourseEnrollment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, Buutti!");

        // Create courses
        var c = new Course("CS.001", "Alkeiskurssi: Ohjelmointia puupäille", new ArrayList<>());
        var c2 = new Course("CS.002", "Angular-ohjelmointia aamuvirkuille", new ArrayList<>());
        var c3 = new Course("CS.003", "F# ohjelmointia fakiireille", new ArrayList<>());

        // Students
        Student s1 = new Student("1000", "Seppo Seppola");
        Student s2 = new Student("2000", "Teppo Teppola");
        Student s3 = new Student("3000", "Matti Mattila");

        c.addStudent(s1.id());
        c3.addStudent(s1.id());
        c.addStudent(s2.id());


        try {
            final List<StudentCourseEnrollment> courseEnrollments = getCourseEnrollments(
                    Arrays.asList(s1, s2, s3),
                    Arrays.asList(c, c2, c3)
            );


            for (final var ce : courseEnrollments) {
                System.out.printf("%s on ilmoittautunut (%d kpl): %s%n", ce.s(), ce.courseIDs().size(), ce.courseIDs());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    static List<StudentCourseEnrollment> getCourseEnrollments(List<Student> students, List<Course> courses) throws Exception {

        // All students with their courses
        ArrayList<StudentCourseEnrollment> enrollments = new ArrayList<>();

        if(students == null || courses==null) {
            throw new Exception("Give me some proper data");
        }

        for(Student s : students) {

            // Students courses found
            List<String> sCourses = new ArrayList<>();

            for(Course c : courses) {
                if(c.getStudentIds().contains(s.id())) {
                    sCourses.add(c.getId());
                }
            }

            enrollments.add(new StudentCourseEnrollment( s, sCourses ));

        }

        return enrollments;

    }

}