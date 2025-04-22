package com.yundee.ui;


import com.yundee.ui.component.panel.FileListPanel;
import com.yundee.ui.component.panel.SidePanel;
import com.yundee.ui.component.textarea.DetailTextArea;

import javax.swing.*;
import java.awt.*;

public class RootMenu {
    public static void create() {
        JFrame frame = new JFrame();
        frame.setTitle("阿里云文件管理器");
        frame.setLocationRelativeTo(null); //弹出位置屏幕中心
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //当点击关闭按钮时，退出程序
        frame.setSize(600,800);
        JPanel mainPanel = new JPanel(new FlowLayout());
        mainPanel.add(FileListPanel.getInstance());
        mainPanel.add(SidePanel.getInstance());
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
