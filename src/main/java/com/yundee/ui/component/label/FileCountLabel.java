package com.yundee.ui.component.label;

import javax.swing.*;

public class FileCountLabel extends JLabel {
    private static FileCountLabel instance;

    private FileCountLabel() {}

    public static FileCountLabel getInstance() {
        if (instance == null) {
            instance = new FileCountLabel();
        }
        return instance;
    }

    public void setData(Integer count){
        String countString = String.valueOf(count);
        this.setText(" 当前批次文件: " + countString);
    }
}
