/**
 *
 * 设置关闭快捷键
 *
 */

package com.GUI;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Shortcut {
    public void shortcut(JFrame frame) {
        //加入键盘监听器
        frame.setFocusable(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 27)
                    System.exit(1);
            }
        });
    }
}
