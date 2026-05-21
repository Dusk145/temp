package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import model.Ranking;

public class RankingDAO extends DAO{
    public RankingDAO(){
        super();
    }

    public ArrayList <Ranking> getRanking(int stageID){
        ArrayList <Ranking> res = new ArrayList<>();
        String sql = 
            "select * " +
            "from ( " +
                "select a.racerName, a.nationality, a.teamName, " + 
                    "sum (case a.finishRank when 1 then 25 " + "when 2 then 18 " + "when 3 then 15 " + "when 4 then 12 " + "when 5 then 10 " + 
                        "when 6 then 8" + "when 7 then 6 " + "when 8 then 4 " + "when 9 then 2 " + "when 10 then 1 " + "else 0 end " +
                        "as totalScore, " + 
                    "sum(case when a.timeToFinish > 0 then a.timeToFinish else 0 end as totalTime " + 
                "from ( " + 
                    "select r.racerID, r.racerName, r.nationality, t.teamID, t.teamName, s.stageID, res.timeToFinish, " + 
                        "case when res.timeToFinish > 0 then dense_rank() over ( " + 
                            "partition by s.stageID " + 
                            "order by res.timeToFinish asc " + 
                        "else null end as finishRank " + 
                    "from racer r " + 
                    "left join contract c on c.racerID = r.racerID " + 
                    "left join team on t.teamID = c.teamID " + 
                    "left join result res on res.contractID = c.contractID " + 
                    "left join stage s on s.stageID = res.stageID and s.stageID <= ? " + 
                ") as a " + 
                "group by a.racerID, a.racerName " + 
            ") as b " +
            "order by b.totalScore desc, case when b.totalScore = 0 and b.totalTimne = 0 then 1 else 0 end asc, b.totalTime asc, b.racerName asc;";
                  
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stageID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Ranking r = new Ranking();
                r.setTotalScore(rs.getInt("totalScore"));
                r.setTotalTime(rs.getDouble("totalTime"));
                r.setRacerName(rs.getString("racerName"));
                r.setNationality(rs.getString("nationality"));
                r.setTeamName(rs.getString("teamName"));
                res.add(r);
            }
        } catch (Exception e) {
			e.printStackTrace();
		}
        return res;
    }
}
