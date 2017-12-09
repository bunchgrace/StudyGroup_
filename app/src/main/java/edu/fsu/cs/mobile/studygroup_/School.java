package edu.fsu.cs.mobile.studygroup_;

public class School{
    private String name;
    private int courseNum;
    private Course[] courseList;

    public School(String n) {
        name = n;
        courseNum = 0;
        courseList = new Course[5];
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course c) {
        courseList[courseNum++] = c;
    }

    public void removeCourse() {
        courseNum--;
    }
}