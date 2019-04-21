package com.GUI;

import com.code.Employee;
import com.code.EmployeeOperation;
import com.code.SelectMainTest;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Print {
    String s;
    int n = 1;
    public void
        print() {
        List<Employee> winner_List = EmployeeOperation.getInstance().selectWinner();
        int word = winner_List.size();

        JFrame jf = new JFrame();
        jf.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        Font ft = new Font("楷体", Font.BOLD, 40);//字体
        s = "<html><body> ";
        for (int i = 0; i < 10 && i < word; i++) {
            if (i <= 8) {
                s = s + '0' + String.valueOf(i + 1) + ' ' + winner_List.get(i).getEmpNum()+' ' + winner_List.get(i).getWinner_time()+' '+winner_List.get(i).getWinner_award();
                s = s + "<br>";
            }
            else s = s + String.valueOf(i + 1) + ' ' + winner_List.get(i).getEmpNum() +' '+ winner_List.get(i).getWinner_time()+' '+winner_List.get(i).getWinner_award();
        }
        s = s + "<html><body>";
        label.setText(s);
        label.setFont(ft);
        JPanel panel = new JPanel();
        JButton button1 = new JButton("上一页");
        JButton button2 = new JButton("下一页");
        panel.add(button1);
        panel.add(button2);
        jf.add(label);
        jf.add(panel, BorderLayout.SOUTH);
        jf.pack();
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));
        jf.setResizable(false);
        jf.setVisible(true);

        //SelectMainTest.getSelect().selectWinner();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (n == 1){
                }
                else {
                    n--;
                    s = "<html><body> ";
                    for (int i = 0; i < 10 && i < word; i++) {
                        if (i <= 8 && n == 1) {
                            s = s + '0' + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n - 1) * 10 +i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                            s = s + "<br>";
                        }
                        else if(i <= 8) {
                            s = s + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n-1)*10+i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                            s = s + "<br>";
                        }
                        else   s = s + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n - 1) * 10 +i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                    }
                    s = s + "<html><body>";
                }
                label.setText(s);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(winner_List.size()%10 == 0){
                        if(n < (word/10))
                            n++;
                    }
                    else if( word%10 != 0){
                        if(n < (word/10+1))
                            n++;
                    }
                    s = "<html><body> ";
                    for (int i = 0; i < 10 &&  (n - 1) * 10 + i<word; i++) {
                        if (i <= 8 && n == 1) {
                            s = s + '0' + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n - 1) * 10 +i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                            s = s + "<br>";
                        }
                        else if(i <= 8) {
                            s = s + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n - 1) * 10 +i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                            s = s + "<br>";
                        }
                        else   s = s + String.valueOf((n - 1) * 10 + i + 1) + ' ' + winner_List.get((n - 1) * 10 +i).getEmpNum()+' ' + winner_List.get((n - 1) * 10 +i).getWinner_time()+' '+winner_List.get((n-1)*10+i).getWinner_award();
                    }
                    s = s + "<html><body>";
                label.setText(s);
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Manage().manage();
            }
        });

        jf.setFocusable(true);
        new Shortcut().shortcut(jf);
    }
}
