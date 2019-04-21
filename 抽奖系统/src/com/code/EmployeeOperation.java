package com.code;
import com.code.DatabaseConnection;
import com.code.Employee;

import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOperation {
    private static EmployeeOperation instance = new EmployeeOperation();
    public static EmployeeOperation getInstance(){
        return instance;
    }
    private EmployeeOperation(){}

    public boolean saveEmployee(Employee emp){//向members数据库加数据
        boolean result = false;
        Connection conn = null;
        try{
            conn = DatabaseConnection.getcon();
            String sql = "insert into enterprise.members(id,number, name) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,emp.getEmpId());
            stmt.setString(2,emp.getEmpNum());
            stmt.setString(3,emp.getEmpName());
            int i = stmt.executeUpdate();
            if(i == 1){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Employee> selectEmployee(){//将members数据存入List
        List<Employee> empList = new ArrayList<Employee>();
        Connection conn = null;
        try{
            conn = DatabaseConnection.getcon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from enterprise.members");

            while (rs.next()== true){
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("id"));
                emp.setEmpNum(rs.getString("number"));
                emp.setEmpName(rs.getString("name"));
                empList.add(emp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return empList;
    }

    public boolean deleteEmployeeByName(Employee emp){//从members数据库中删除
        boolean result = false;
        Connection conn = null;
        try{
            conn = DatabaseConnection.getcon();
            String sql = "delete from enterprise.members where name= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,emp.getEmpName());
            int i = stmt.executeUpdate();
            if(i == 1){
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  result;
    }

    public static void saveWinner(String winner_num,String winner_time,String winner_award){//向winner数据库中加入信息
        Connection conn = null;
        try {
            conn = DatabaseConnection.get_wincon();
            String sql =  "insert into winner(winner_num, winner_time,winner_award) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,winner_num);
            stmt.setString(2,winner_time);
            stmt.setString(3,winner_award);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Employee> selectWinner(){//从winner数据库查询所需数据
        List<Employee> win_List = new ArrayList<Employee>();
        Connection conn = null;
        try{
            conn = DatabaseConnection.getcon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from enterprise.winner");
            while (rs.next()== true){
                Employee emp = new Employee();
                emp.setEmpNum(rs.getString("winner_num"));
                emp.setWinner_time(rs.getString("winner_time"));
                emp.setWinner_award(rs.getString("winner_award"));
                win_List.add(emp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return win_List;
    }
    public void dropMembers(){
        Connection conn = null;
        try {
            conn = DatabaseConnection.getcon();
            String sql = "delete from enterprise.members where  id > '0'";
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
