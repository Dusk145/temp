package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Season implements Serializable{
    private int seasonID, year;
    private String seasonName;
    ArrayList <Stage> stage;

    public Season(){
        super();
    }

    public Season(int SeasonID, int Year, String SeasonName, ArrayList <Stage> SStage){
        this.seasonID = SeasonID;
        this.year = Year;
        this.seasonName = SeasonName;
        this.stage = SStage;
    }
}