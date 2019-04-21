/**
 *
 * 获取窗口合适的坐标
 *
 */
package com.GUI;

import java.awt.*;

public class GetWindowLocation {
    public Point getLocation(int w, int h) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        return new Point((sw - w) / 2, (sh - h) / 3);
    }
}
