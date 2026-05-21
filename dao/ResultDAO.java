package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import model.Result;
import model.Contract;
import model.Stage;

public class ResultDAO extends DAO{
    public ResultDAO(){
        super();
    }

    public ArrayList <Result> getResultOfRacer(int racerID, int stageID){
        ArrayList <Result> res = new ArrayList<>();
        String sql = 
            "select s.stageName, " + 
                "case when a.contractID is null then 'DNP' " + "when a.timeToFinish = 0 then 'DNF' " + "else cast(a.finishRank as char) " + 
                    "end as finishRank, " + 
                "case a.finishRank when 1 then 25 " + "when 2 then 18 " + "when 3 then 15 " + "when 4 then 12 " + "when 5 then 10 " + 
                    "when 6 then 8" + "when 7 then 6 " + "when 8 then 4 " + "when 9 then 2 " + "when 10 then 1 " + "else 0 end as score " +
                "a.timeToFinish " + 
            "from stage s " + 
            "left join contract c on c.racerID = ? and date(s.`time`) between c.startDate and c.endDate " + 
            "left join ( " + 
                "select res.stageID, res.contractID, res.timeToFinish, " + 
                    "case when res.timeToFinish > 0 then dense_rank() over ( " + 
                        "partition by s.stageID " + 
                        "order by res.timeToFinish asc " + 
                    "else null end as finishRank " + 
                "from result res " + 
            ") as a on a.stageID = s.stageID and a.contractID = c.contractID " + 
            "where s.stageID <= ? " + 
            "order by s.stageID asc;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, racerID);
            ps.setInt(1, stageID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Result r = new Result();
                r.setTimeToFinish(rs.getDouble("timeToFinish"));

                Stage stage = new Stage();
                stage.setStageName("stageName");
                r.setStage(stage);

                
                res.add(r);
            }
        } catch (Exception e) {
			e.printStackTrace();
		}
        return res;
    }
}