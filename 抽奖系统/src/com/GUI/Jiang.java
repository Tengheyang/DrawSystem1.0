package com.GUI;

import com.code.Award;
import com.code.AwardSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jiang {
    static String s;
    public void jiang() {
        com.code.Award award = new Award();
        JFrame jf = new JFrame();
        JTextField text = new JTextField(30);
        JPanel panel = new JPanel();
        JButton button = new JButton("确定");
        jf.setLayout(new GridLayout(2, 1));
        jf.add(text);
        panel.add(button);
        jf.add(panel);
        jf.pack();
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));
        jf.setResizable(false);
        jf.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s = text.getText();
                AwardSelect.getAwardSelect().resetAward(s);
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
