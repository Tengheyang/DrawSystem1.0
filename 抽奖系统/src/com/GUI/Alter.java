/**
 *
 * 修改管理员密码界面
 *
 */
package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Alter {
    static String newpassword;
    public void alter() {
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(3, 1));

        JPanel panel1, panel2, panel3;

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        JLabel label1, label2;
        label1 = new JLabel("请输入旧密码:");
        label2 = new JLabel("请输入新密码:");

        JPasswordField text1 = new JPasswordField(20);
        JPasswordField text2 = new JPasswordField(20);

        JButton button1, button2;
        button1 = new JButton("清除");
        button2 = new JButton("确认");

        JLabel l = new JLabel("");

        panel1.add(label1);
        panel1.add(text1);
        panel1.add(button1);
        panel2.add(label2);
        panel2.add(text2);
        panel2.add(button2);
        panel3.add(l);

        jf.add(panel1);
        jf.add(panel2);
        jf.add(panel3);

        jf.setVisible(true);
        jf.pack();
        jf.setResizable(false);
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
                button1.setEnabled(false);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = new String(text1.getPassword());
                if (new Change().apass.equals(s)) {
                    newpassword = new String(text2.getPassword());
                    new Change().changepass(newpassword);
                    jf.dispose();
                    new Frame().mainInterface();
                } else
                    l.setText("原密码错误！");
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
