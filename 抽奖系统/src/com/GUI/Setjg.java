package com.GUI;

import com.code.AwardSelect;
import com.code.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Setjg {
    int number;
    String  rank, name, rate;
    Award award = new Award();
    public void setjg() {
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(5,1));
        JLabel l1, l2, l3,l4;
        l1 = new JLabel("请输入您想设置的奖项个数:");
        l2 = new JLabel("请输入您想设置的奖项级别:");
        l3 = new JLabel("请输入您想设置的奖项名称:");
        l4 = new JLabel("请输入您想设置的奖项概率:");
        JTextField t1, t2, t3, t4;
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        JButton button = new JButton("确认");
        JPanel p1, p2, p3, p4, p5;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(l3);
        p3.add(t3);
        p4.add(l4);
        p4.add(t4);
        p5.add(button);
        jf.add(p1);
        jf.add(p2);
        jf.add(p3);
        jf.add(p4);
        jf.add(p5);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.pack();
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                number = Integer.valueOf(t1.getText());
                rank = t2.getText();
                name = t3.getText();
                rate = t4.getText();
                AwardSelect.getAwardSelect().setAward(number,rank,name,rate);
                jf.dispose();
                new Manage().manage();
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
