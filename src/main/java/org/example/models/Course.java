package org.example.models;

import java.util.List;

public class Course {

    private String id;
    private String courseName;
    private List<String> studentIds;


    public Course(
            String id,
            String courseName,
            List<String> studentIds
    ) {
        this.id = id;
        this.courseName = courseName;
        this.studentIds = studentIds;
    }

    //

    /*
    * Adds student to course if not already
    * */
    public void addStudent(String id) {
        if(id != null) {
            if(! this.studentIds.contains(id)) {
                this.studentIds.add(id);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    public boolean equals(Course c) {
//        if(c == null) { return false; }
//        return this.id.equals(c.id);
//    }

    @Override
    public String toString() {
        return "<#%s: %s>".formatted(this.id, this.courseName);
    }
}
