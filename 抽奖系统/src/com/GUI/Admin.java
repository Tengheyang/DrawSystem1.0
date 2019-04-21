/**
 *
 * 管理员登录界面
 *
 */

package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {//管理员界面
    public String name = "T";
    public String word = "2";//初始账号及密码

    public void ui() {
        JFrame jf = new JFrame();
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("请输入用户名及密码:", JLabel.CENTER);
        JLabel label2 = new JLabel("账 号：");
        JLabel label3 = new JLabel("密 码：");
        JLabel label4 = new JLabel("管理员登录系统", JLabel.CENTER);
        JButton button1 = new JButton("登录");
        JButton button2 = new JButton("重置");
        JTextField text = new JTextField(20);
        JPasswordField password = new JPasswordField(20);//设置组件

        panel1.add(label2);
        panel1.add(text);
        panel1.add(button1);

        panel2.add(label3);
        panel2.add(password);
        panel2.add(button2);//添加组件

        jf.setLayout(new GridLayout(4, 1, 0, 0));
        jf.add(label1);
        jf.add(panel1);
        jf.add(panel2);
        jf.add(label4);
        jf.setLocation(530, 180);
        jf.pack();
        jf.setVisible(true);//添加组件及设计布局

        button1.addActionListener(new ActionListener() {//添加监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = new String(password.getPassword());
                if (name.equals(text.getText()) && word.equals(s)) {
                    label4.setText("登录成功！");
                    new Manage().manage();
                    jf.dispose();

                } else
                    label4.setText("登录失败！");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                password.setText("");
                label4.setText("管理员登录系统");
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Frame().mainInterface();
            }
        });

        //加入键盘监听器
        jf.setLocation(new GetWindowLocation().getLocation(jf.getWidth(), jf.getHeight()));
        jf.setResizable(false);
        jf.setFocusable(true);

        new Shortcut().shortcut(jf);
    }

}