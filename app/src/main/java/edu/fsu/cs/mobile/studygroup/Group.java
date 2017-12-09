package edu.fsu.cs.mobile.studygroup;

public class Group {
    static private int MAXUSERS = 5;
    private int groupNum;
    private int eventNum;
    private int userNum;
    private Event[] eventList;
    private User[] userList;

    public Group(int gn) {
        groupNum = gn;
        eventNum = 0;
        userNum = 0;

        eventList = new Event[5];
        userList = new User[MAXUSERS];
    }

    public void addUser(User u){
        userList[userNum++] = u;
    }

    public void removeUser(){
        userNum--;
    }

    public void addEvent(Event e) {
        eventList[eventNum++] = e;
    }

    public void removeEvent(int index){
        eventNum--;
    }

    public int getEventNum() {
        return eventNum;
    }

    public int getGroupNum() {
        return groupNum;
    }
}