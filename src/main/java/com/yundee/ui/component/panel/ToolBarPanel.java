package com.yundee.ui.component.panel;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {
    private static ToolBarPanel instance;
    private ToolBarPanel() {
        super(new FlowLayout());
        this.buildFlashDataButton();
        this.buildDeleteAllButton();
        this.buildDeleteOneButton();
    }

    public static ToolBarPanel getInstance() {
        if (instance == null) {
            instance = new ToolBarPanel();
        }
        return instance;
    }
    private void buildDeleteOneButton(){
        JButton button = new JButton("删除");
    }
    private void buildDeleteAllButton(){

    }
    private void buildFlashDataButton(){

    }
}
