package com.GUI;

import com.code.AwardSelect;
import com.code.SelectMainTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Award {
    String s1, s2;
    public void award() {
        s1 = AwardSelect.getAwardSelect().selectAward();//随机选择奖品
        s2 = SelectMainTest.getSelect().selectEmployee(s1);//选择并保存winner信息
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("", JLabel.CENTER);
        JLabel l2 = new JLabel("", JLabel.CENTER);
        Font ft = new Font("楷体", Font.BOLD, 40);//字体
        l1.setFont(ft);
        l1.setText(s1);
        l2.setFont(ft);
        l2.setText(s2);
        jf.add(l1);
        jf.add(l2);
        jf.pack();
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));
        jf.setVisible(true);
        jf.setResizable(false);

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Frame().mainInterface();
            }
        });

        jf.setFocusable(true);
        jf.setAlwaysOnTop(true);
        new Shortcut().shortcut(jf);
    }
}
