package com.yundee.ui.component.panel;

import com.yundee.ui.component.list.FileList;
import lombok.extern.slf4j.Slf4j;
import javax.swing.*;

@Slf4j
public class FileListPanel extends JScrollPane {
    private static FileListPanel instance;
    public static FileListPanel getInstance() {
        if (instance == null) {
            instance = new FileListPanel();
            instance.init();
        }
        return instance;
    }
    private void init(){
        FileList fileList = FileList.getInstance();
        this.setViewportView(fileList);
    }
    private FileListPanel() {}


}
