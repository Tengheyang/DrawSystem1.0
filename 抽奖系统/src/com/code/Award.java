package com.code;
public class Award {

    private int award_rank;
    private String award_name;
    private double award_rate;

    public void setAward_rank(int rank){this.award_rank = rank;}
    public int getAward_rank(){return this.award_rank;}

    public void setAward_name(String name){this.award_name = name;}
    public String getAward_name(){return this.award_name;}

    public void setAward_rate(double rate){this.award_rate = rate;}
    public double getAward_rate(){return this.award_rate;}
}
