package com.yundee.ui.component;

import com.yundee.domain.FileItem;
import com.yundee.handler.ListHandler;

import javax.swing.*;
import java.util.List;

public class DetailPanel {

    public static JPanel getPanel(){
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel();
        panel.add(jLabel);
        return panel;
    }
}
