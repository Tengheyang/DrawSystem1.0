package com.code;
import com.code.Award;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AwardOperation {

    private static AwardOperation awardOperation = new AwardOperation();
    public static AwardOperation getAwardOperation(){return awardOperation;}
    private AwardOperation(){}

    public void setAward(Award award){//写入award
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_award();
            String sql = "insert into enterprise.award(award_rank,award_name,award_rate) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,award.getAward_rank());
            stmt.setString(2,award.getAward_name());
            stmt.setDouble(3,award.getAward_rate());
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Award> listAward(){//存入List
        List<Award> award_List = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_award();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from enterprise.award");

            while (rs.next()){
                Award aw = new Award();
                aw.setAward_rank(rs.getInt("award_rank"));
                aw.setAward_name(rs.getString("award_name"));
                aw.setAward_rate(rs.getDouble("award_rate"));
                award_List.add(aw);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return award_List;
    }

    public void changeRate(Award award) {//修改概率
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_award();
            String sql = "update enterprise.award set award_rate = ? where award_rank = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, award.getAward_rate());
            stmt.setInt(2, award.getAward_rank());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeName(Award award) { //修改名称
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_award();
            String sql = "update enterprise.award set award_name = ? where award_rank = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(2, award.getAward_rank());
            stmt.setString(1, award.getAward_name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void dropAward(){
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_award();
            String sql = "delete from enterprise.award where award_rank > 0";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}