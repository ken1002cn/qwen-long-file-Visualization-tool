package com.yundee.ui.component.panel;

import com.yundee.ui.component.textarea.DetailTextArea;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private static SidePanel instance;

    private SidePanel() {}

    public static SidePanel getInstance() {
        if (instance == null) {
            instance = new SidePanel();
            instance.setLayout(new BorderLayout());
            instance.add(DetailTextArea.getInstance(), BorderLayout.NORTH);
            instance.add(ToolBarPanel.getInstance(), BorderLayout.SOUTH);
        }
        return instance;
    }
}
