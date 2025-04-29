package com.yundee.ui.component.label;

import javax.swing.*;

public class HasMoreLabel extends JLabel {
    private static HasMoreLabel instance;
    private HasMoreLabel() {}

    public static HasMoreLabel getInstance() {
        if (instance == null) {
            instance = new HasMoreLabel();
        }
        return instance;
    }

    public void setData(String data) {
        String message = "异常";
        if (data == "true"){
            message = "状态:存在更多批次数据";
        }else if (data == "false"){
            message = "状态:数据已全部展示";
        }
        setText(message);
    }
}
