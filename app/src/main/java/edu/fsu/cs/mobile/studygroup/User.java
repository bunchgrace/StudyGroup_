package edu.fsu.cs.mobile.studygroup;

public class User{
    private String username;
    private String password;
    private int groupNum;
    private int[] groups;
    private int points;

    public User(String u, String p) {
        username = u;
        password = p;
        points = 0;
        groupNum = 0;
        groups = new int[5];

        //database????
    }

    public String getUsername() {
        return username;
    }

    public boolean correctPassword(String p) {
        if (password.equals(p))
            return true;
        else
            return false;
    }

    public void addGroup(int g) {
        groups[groupNum++] = g;
    }

    public void addPoints(int p) {
        points += p;
    }

    public int getPoints() {
        return points;
    }
}