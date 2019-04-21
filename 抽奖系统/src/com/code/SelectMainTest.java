package com.code;
import com.code.Employee;
import com.code.EmployeeOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.lang.String;

public class SelectMainTest {
    private static SelectMainTest select = new SelectMainTest();
    public static SelectMainTest getSelect() {return select;}
    private SelectMainTest(){}

    public void insertEmployee(Employee emp){//从文件导入数据到members
        File file = new File("C:\\Users\\28135\\IdeaProjects\\Test\\src\\com\\code\\员工.txt");
        try{
            EmployeeOperation.getInstance().dropMembers();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                emp.setEmpId(str.split(" ")[0]);
                emp.setEmpNum(str.split(" ")[1]);
                emp.setEmpName(str.split(" ")[2]);
                EmployeeOperation.getInstance().saveEmployee(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteEmployee(String name){//从members中删除数据
        Employee emp = new Employee();
        emp.setEmpName(name);
        EmployeeOperation.getInstance().deleteEmployeeByName(emp);
    }

    public String selectEmployee(String winner_award){//从members中选择一条数据并存入winner==抽奖
        List<Employee> empList = EmployeeOperation.getInstance().selectEmployee();

        int i = (int)(Math.random()*empList.size());
        String str;
        str = empList.get(i).getEmpId() + ' ' + empList.get(i).getEmpName()+ ' '+ empList.get(i).getEmpNum();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String winner_time;
        winner_time = df.format(new Date());
        EmployeeOperation.getInstance().saveWinner(empList.get(i).getEmpNum(),winner_time,winner_award);
        return str;
    }

}