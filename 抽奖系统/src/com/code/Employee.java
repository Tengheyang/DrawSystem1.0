package com.code;
public class Employee {
    private String empId;
    private String empNum;
    private String empName;
    private String winner_time;
    private String winner_award;

    public void setEmpId(String id){
        this.empId = id;
    }
    public String getEmpId(){
        return this.empId;
    }

    public void setEmpNum(String num){
        this.empNum = num;
    }
    public String getEmpNum(){
        return this.empNum;
    }

    public void setEmpName(String name){
        this.empName = name;
    }
    public String getEmpName(){
        return this.empName;
    }

    public void setWinner_time(String time){this.winner_time = time;}
    public String getWinner_time(){return winner_time;}

    public void setWinner_award(String award){this.winner_award = award;}
    public String getWinner_award(){return this.winner_award;}

}
