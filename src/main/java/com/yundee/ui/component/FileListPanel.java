package com.yundee.ui.component;

import com.yundee.domain.FileItem;
import com.yundee.handler.ListHandler;
import lombok.extern.slf4j.Slf4j;
import javax.swing.*;
import java.util.List;

@Slf4j
public class FileListPanel {

   public static JScrollPane getPanel(){
        List<FileItem> fileItemList = ListHandler.list();
        DefaultListModel<FileItem> model = new DefaultListModel<>();
        for(FileItem item : fileItemList){
            model.addElement(item);
        }
        JList<FileItem> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        //点击事件监听器
        list.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){ //如果用户还在 拖动或没松开鼠标，不触发事件
                FileItem selected = list.getSelectedValue();
                if(selected != null){
                    log.info("当前选中：{}", selected.getId());
                }
            }
        });
        return scrollPane;
    }

}
