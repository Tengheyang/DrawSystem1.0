package com.code;
import java.sql.*;

public class DatabaseConnection {

    private static Connection conn = null;
    public static Connection getcon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "123456";
            String url = "jdbc:mysql://localhost:3306/enterprise?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection get_wincon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "123456";
            String ur2 = "jdbc:mysql://localhost:3306/enterprise?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(ur2,user,pass);
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection get_award(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "123456";
            String ur3 = "jdbc:mysql://localhost:3306/enterprise?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(ur3,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
