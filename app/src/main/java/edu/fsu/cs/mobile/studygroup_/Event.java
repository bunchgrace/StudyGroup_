package edu.fsu.cs.mobile.studygroup_;

public class Event{
    private int start;
    private int end;
    private int location;
    private User[] attended;
    private int userCount;

    public Event(int s, int e, int l) {
        start = s;
        end = e;
        location = l;
        userCount = 0;
        attended = new User[5];

        //update database???
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getLocation() {
        return location;
    }

    public boolean checkIn(int time, User user) {
        if (time < end && time > start) {
            attended[userCount++] = user;
            return true;
        }
        else
            return false;
    }

    public void givePoints()
    {
        if (userCount == 0)
            return;
        for (int i = 0; i < userCount; i++) {
            attended[i].addPoints(100 * userCount);
        }
    }
}