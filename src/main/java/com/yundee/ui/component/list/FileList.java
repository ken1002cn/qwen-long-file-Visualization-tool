package com.yundee.ui.component.list;

import com.yundee.domain.FileItem;
import com.yundee.domain.ListMessage;
import com.yundee.handler.ListHandler;
import com.yundee.ui.component.label.FileCountLabel;
import com.yundee.ui.component.label.HasMoreLabel;
import com.yundee.ui.component.textarea.DetailTextArea;
import lombok.extern.slf4j.Slf4j;
import javax.swing.*;
import java.util.List;

@Slf4j
public class FileList extends JList<FileItem> {
    private static FileList instance;

    public static FileList getInstance() {
        if (instance == null) {
            instance = new FileList();
            //添加点击事件监听器
            instance.addListSelectionListener(e -> {
                if(!e.getValueIsAdjusting()){ //如果用户还在 拖动或没松开鼠标，不触发事件
                    FileItem selected = instance.getSelectedValue();
                    if(selected != null){
                        log.info("当前选中{}",selected.getFilename());
                        DetailTextArea.getInstance().setText(selected);
                    }
                }
            });
//            instance.flashData();
        }
        return instance;
    }
    private FileList() {}

    public void flashData(){
        ListMessage listMessage = ListHandler.listData();
        DefaultListModel<FileItem> model = new DefaultListModel<>();
        for(FileItem item : listMessage.getData()){
            model.addElement(item);
        }
        instance.setModel(model);
        FileCountLabel.getInstance().setData(listMessage.getData().size());
        HasMoreLabel.getInstance().setData(listMessage.getHas_more());
    }
}
