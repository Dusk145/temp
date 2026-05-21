package model;

import java.io.Serializable;

public class Result implements Serializable{
    private int resultID;
    private double timeToFinish;
    private Stage stage;
    private Contract contract;

    public Result(){
        super();
    }

    public Result(int ResultID, double TimeToFinish, Stage SStage, Contract CContract){
        this.resultID = ResultID;
        this.timeToFinish = TimeToFinish;
        this.stage = SStage;
        this.contract = CContract;
    }

    public void setTimeToFinish(double TimeToFinish){
        this.timeToFinish = TimeToFinish;
    }

    public void setStage(Stage SStage){
        this.stage = SStage;
    }

    public void setContract(Contract CContract){
        this.contract = CContract;
    }
}