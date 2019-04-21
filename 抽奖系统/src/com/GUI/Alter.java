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
    public void alter() {
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(2, 1));

        JPanel panel1, panel2;
        panel1 = new JPanel();
        panel2 = new JPanel();

        JLabel label1, label2;
        label1 = new JLabel("新名字:");
        label2 = new JLabel("新密码:");

        JTextField text1, text2;
        text1 = new JTextField(20);
        text2 = new JTextField(20);

        JButton button1, button2;
        button1 = new JButton("清除");
        button2 = new JButton("确认");

        panel1.add(label1);
        panel1.add(text1);
        panel1.add(button1);
        panel2.add(label2);
        panel2.add(text2);
        panel2.add(button2);

        jf.add(panel1);
        jf.add(panel2);


        jf.setVisible(true);
        jf.pack();
        jf.setResizable(false);
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Frame().mainInterface();
            }
        });

        new Shortcut().shortcut(jf);
    }
}
