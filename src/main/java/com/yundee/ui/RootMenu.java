package com.yundee.ui;

import com.yundee.ui.component.FileListPanel;

import javax.swing.*;
import java.awt.*;

public class RootMenu {
    private static JFrame frame;
    private static JPanel mainPanel;
    public static void create() {
        init();

        mainPanel.add(FileListPanel.getPanel(), BorderLayout.CENTER);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
    private static void init(){
        frame = new JFrame();
        frame.setTitle("阿里云文件管理器");
        frame.setLocationRelativeTo(null); //弹出位置屏幕中心
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //当点击关闭按钮时，退出程序
        frame.setSize(600,800);
        mainPanel = new JPanel(new BorderLayout());

    }
}
