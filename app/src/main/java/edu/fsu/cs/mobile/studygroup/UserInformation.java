package edu.fsu.cs.mobile.studygroup;

/**
 * Created by gracebunch on 12/5/17.
 */
//to read user information from database so it can be printed in the appp
public class UserInformation {

    private String username;
    private Integer points;

    public UserInformation(){}


    public String getUsername(){
        return username;
    }
    public String setUsername(String username){
        return this.username=username;
    }

    public Integer getPoints(){
        return points;
    }


}

