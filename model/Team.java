package model;

import java.io.Serializable;

public class Team implements Serializable{
    private int teamID;
    private String teamName, brand, description;

    public Team(){
        super();
    }

    public Team(int TeamID, String TeamName, String Brand, String Description){
        this.teamID = TeamID;
        this.teamName = TeamName;
        this.brand = Brand;
        this.description = Description;
    }

    public void setTeamName(String TeamName){
        this.teamName = TeamName;
    }
}