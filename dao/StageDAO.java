package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import model.Stage;

public class StageDAO extends DAO{
    public StageDAO(){
        super();
    }

    public ArrayList <Stage> getAllStages(){
        ArrayList <Stage> res = new ArrayList<>();
        String sql = 
            "select s.stageName " + 
            "from stage s;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Stage s = new Stage();
                s.setStageName(rs.getString("stageName"));
                res.add(s);
            }
        } catch (Exception e) {
			e.printStackTrace();
		}
        return res;
    }
}