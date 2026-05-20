package model;

import java.io.Serializable;
import java.util.Date;

public class Racer implements Serializable{
    private int racerID;
    private String racerName, nationality, biography;
    private Date birth;

    public Racer(){
        super();
    }

    public Racer(int RacerID, String RacerName, String Nationality, String Biography, Date Birth){
        this.racerID = RacerID;
        this.racerName = RacerName;
        this.nationality = Nationality;
        this.biography = Biography;
        this.birth = Birth;
    }

    public void setRacerName(String RacerName){
        this.racerName = RacerName;
    }

    public void setNationality(String Nationality){
        this.nationality = Nationality;
    }
}