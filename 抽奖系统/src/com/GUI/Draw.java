
/**
 *
 * 主界面
 *
 */
package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame extends JFrame {//界面
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int sw = screenSize.width;
    int sh = screenSize.height;
    public void mainInterface() {//主窗口

        //设置背景图片及缩放
        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("C:\\Users\\28135\\IdeaProjects\\Test\\3.png");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        p.setLayout(null);



        //最上方的提示语
        JLabel label1;
        label1 = new JLabel("欢迎来到抽奖系统", JLabel.CENTER);
        Font ft = new Font("楷体", Font.BOLD, 80);//字体
        label1.setFont(ft);
        label1.setForeground(Color.RED);
        label1.setBounds((sw - 700) / 2,70 ,700, 70);

        JButton button1 = new JButton("管理员入口");
        button1.setBounds((sw - 120) / 2,sh - 30 ,120, 25);

        JButton button2 = new JButton("开始抽奖");
        button2.setBounds((sw - 120) / 2, (int)(sh * 0.65), 120, 50);

        //添加组件
        p.add(label1);
        p.add(button1);
        p.add(button2);

        //设置全屏窗口
        JFrame f = new JFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setBounds(0, 0, dimension.width, dimension.height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.setVisible(true);
        f.add(p);

        //加入键盘监听器
        f.setFocusable(true);
        new Shortcut().shortcut(f);

        //加入按钮监听器
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyFrame().ui();
                button1.setEnabled(false);
                button2.setEnabled(false);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Award().award();
                button2.setEnabled(false);
            }
        });

    }
}

