package edu.fsu.cs.mobile.studygroup;

public class Course{
    private String courseNum;
    private Group[] groups;
    private int groupNum;

    public Course(String cn) {
        courseNum = cn;
        groups = new Group[5];
    }

    public void addGroup(Group g) {
        groups[groupNum++] = g;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void removeGroup() {
        groupNum--;
    }
}