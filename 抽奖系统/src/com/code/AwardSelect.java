package com.code;
import com.code.Award;
import com.code.AwardOperation;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AwardSelect {
    private static AwardSelect awardSelect = new AwardSelect();
    public static AwardSelect getAwardSelect(){ return awardSelect;}
    private AwardSelect(){};
    int length = AwardOperation.getAwardOperation().listAward().size();
    static char[] Rank = {'一','二','三','四','五','六','七','八','九'};

    public void setAward(int num,String rank,String name,String rate){//设置奖项


        try {
            Award award = new Award();
            AwardOperation.getAwardOperation().dropAward();

            for(int i=0;i<num;i++){
                int thisrank = Integer.valueOf(rank.split(" ")[i]);
                String thisname = name.split(" ")[i];
                double thisrate = Double.valueOf(rate.split(" ")[i]);
                award.setAward_rank(thisrank);
                award.setAward_name(thisname);
                award.setAward_rate(thisrate);
                AwardOperation.getAwardOperation().setAward(award);
            }
        }catch (Exception e){}
    }

    public void resetAward(String str){//修改奖项
        try {
            Award award = new Award();

            for(int i = 1;i <= length;i++){
                String string = str.split(" ")[i-1];
                award.setAward_name(string);
                award.setAward_rank(i);
                AwardOperation.getAwardOperation().changeName(award);
            }
        }catch (Exception e){}
    }

    public void resetLuck(String str){//修改中奖概率

        try {
            Award award = new Award();

            for(int i = 1;i <= length;i++){
                double rate = Double.valueOf(str.split(" ")[i-1]);
                award.setAward_rate(rate);
                award.setAward_rank(i);
                AwardOperation.getAwardOperation().changeRate(award);
            }
        }catch (Exception e){}
    }

    public String selectAward(){ //抽取奖项
        int luck = (int)(Math.random()*1000);
        List<Award> awardList = AwardOperation.getAwardOperation().listAward();
        int size = awardList.size()-1;
        String string = "";
        boolean result = true;
        if(luck <= 1000*awardList.get(0).getAward_rate())
            string = "一等奖 "+awardList.get(0).getAward_name();
        else if( luck > (1000-1000*awardList.get(size).getAward_rate()) )
            string = Rank[size]+"等奖 "+awardList.get( size ).getAward_name();
        else {
            size--;
            while(result){
                double max = 0.0,min = 0.0;
                for(int i=0;i<=size;i++)
                    max +=  awardList.get(i).getAward_rate();
                for(int i=0;i<size;i++)
                    min += awardList.get(i).getAward_rate();
                if(luck > 1000*min && luck <= 1000*max){
                    string = Rank[size]+"等奖 "+awardList.get( size ).getAward_name();
                    result = false;
                }
                else size--;
            }
        }
        return string;
    }
}
