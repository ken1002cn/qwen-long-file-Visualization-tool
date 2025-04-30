package com.yundee.ui.component.textarea;

import com.yundee.domain.FileItem;

import javax.swing.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DetailTextArea extends JTextArea {

    private static DetailTextArea instance;

    private DetailTextArea() {
        setEditable(false); // 禁止编辑
        setLineWrap(true);  // 自动换行
        setWrapStyleWord(true); // 单词内换行
        setCaretPosition(0); // 确保文本从顶部开始
    }

    public static DetailTextArea getInstance() {
        if (instance == null) {
            instance = new DetailTextArea();
        }
        return instance;
    }

    public void setText(FileItem fileItem) {
        long timestamp = Long.parseLong(fileItem.getCreated_at());
        Instant instant = Instant.ofEpochSecond(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String formatted = formatter.format(instant);
        String text = String.format("文件id: %s\n文件类型: %s\n文件大小: %s\n创建时间: %s\n文件名称: %s\n文件用途: %s",
                fileItem.getId(),
                fileItem.getObject(),
                fileItem.getBytes(),
                formatted,
                fileItem.getFilename(),
                fileItem.getPurpose());
        super.setText(text);
    }
}
