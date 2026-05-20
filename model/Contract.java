package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Contract implements Serializable{
    private int contractID;
    private LocalDateTime startDate, endDate;
    private Racer racer;
    private Team team;

    public Contract(){
        super();
    }

    public Contract(int ContractID, LocalDateTime StartDate, LocalDateTime EndDate, Racer RRacer, Team TTeam){
        this.contractID = ContractID;
        this.startDate = StartDate;
        this.endDate = EndDate;
        this.racer = RRacer;
        this.team = TTeam;
    }
}
