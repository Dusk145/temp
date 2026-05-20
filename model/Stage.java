package model;

import java.io.Serializable;

import java.time.LocalDateTime;

public class Stage implements Serializable{
    private int stageID, numberOfLaps;
    private String stageName, location, description;
    private LocalDateTime time;

    public Stage(){
        super();
    }

    public Stage(int StageID, int NumberOfLaps, String StageName, String Location, String Description, LocalDateTime Time){
        this.stageID = StageID;
        this.numberOfLaps = NumberOfLaps;
        this.stageName = StageName;
        this.location = Location;
        this.description = Description;
        this.time = Time;
    }
}