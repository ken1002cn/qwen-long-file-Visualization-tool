package com.yundee.ui;


import com.yundee.ui.component.panel.FileListPanel;
import com.yundee.ui.component.panel.SidePanel;
import javax.swing.*;

public class RootComponent {
    public static JFrame frame;
    public static JSplitPane panel;
    public static void run(){
        if (frame !=null || panel !=null ){
            throw new RuntimeException("界面已被创建");
        }
        frame = new JFrame();
        frame.setTitle("阿里云文件管理器");
        frame.setLocationRelativeTo(null); //弹出位置屏幕中心
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //当点击关闭按钮时，退出程序
        frame.setSize(600,600);

        panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,FileListPanel.getInstance(),SidePanel.getInstance());
        panel.setContinuousLayout(true);
        panel.setOneTouchExpandable(true);
        panel.setDividerLocation(150);

        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
