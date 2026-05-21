package model;

import java.util.Locale;

public class Ranking extends Racer{
    private int totalScore;
    private double totalTime;
    private String teamName;
    
    public Ranking(){
        super();
    }

    public Ranking(int TotalScore, double TotalTime, String TeamName){
        this.totalScore = TotalScore;
        this.totalTime = TotalTime;
        this.teamName = TeamName;
    }

    public void setTotalScore(int TotalScore){
        this.totalScore = TotalScore;
    }

    public void setTotalTime(double TotalTime){
        this.totalTime = TotalTime;
    }

    public void setTeamName(String TeamName){
        this.teamName = TeamName;
    }

    public String changeTime(double ToTalTime){
        if (Double.isNaN(totalTime)) {
            return "00:00:00.000";
        }
        long totalMillis = Math.round(totalTime * 1000.0);
        long hours = totalMillis / 3_600_000;
        long minutes = (totalMillis % 3_600_000) / 60_000;
        long seconds = (totalMillis % 60_000) / 1_000;
        long millis = totalMillis % 1_000;
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }
}
