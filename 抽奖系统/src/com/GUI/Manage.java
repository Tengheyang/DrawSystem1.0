/**
 *
 * 管理界面
 *
 */

package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Manage {
    public void manage() {
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(5,1));
        Font ft1 = new Font("楷体", Font.BOLD, 30);//字体
        Font ft2 = new Font("楷体", Font.BOLD, 20);

        JButton button1, button2, button3, button4, button5;
        button1 = new JButton("修改奖项");
        button2 = new JButton("修改概率");
        button3 = new JButton("删除人员信息");
        button4 = new JButton("打印中奖名单");
        button5 = new JButton("修改密码");

        jf.add(button1);
        jf.add(button2);
        jf.add(button3);
        jf.add(button4);
        jf.add(button5);

        jf.setLocation(520, 180);
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

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Alter().alter();
                jf.dispose();
            }
        });
        new Shortcut().shortcut(jf);
    }
}
