package com.yundee.ui.component.panel;

import com.yundee.domain.FileItem;
import com.yundee.domain.UserConfig;
import com.yundee.handler.ConfigHandler;
import com.yundee.handler.DeleteHandler;
import com.yundee.ui.RootComponent;
import com.yundee.ui.component.label.FileCountLabel;
import com.yundee.ui.component.label.HasMoreLabel;
import com.yundee.ui.component.list.FileList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarPanel extends JPanel {
    private static ToolBarPanel instance;
    private ToolBarPanel() {
        super(new GridLayout(2,3));
        this.buildFlashDataButton();
        this.buildDeleteAllButton();
        this.buildDeleteOneButton();
        this.add(FileCountLabel.getInstance());
        this.add(HasMoreLabel.getInstance());
        this.buildKeySettingButton();
    }

    public static ToolBarPanel getInstance() {
        if (instance == null) {
            instance = new ToolBarPanel();
        }
        return instance;
    }
    private void buildDeleteOneButton(){
        JButton button = new JButton("删除选中文件");
        button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               FileItem fileItem = FileList.getInstance().getSelectedValue();
               DeleteHandler.deleteById(fileItem.getId());
               JOptionPane.showMessageDialog(
                       null,
                       "删除成功！文件名: " + fileItem.getFilename(),
                       "操作提示",
                       JOptionPane.INFORMATION_MESSAGE
               );
               FileList.getInstance().flashData();
           }
       });
       this.add(button);
    }
    private void buildDeleteAllButton(){
        JButton button = new JButton("删除所有文件");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListModel<FileItem> fileItemListModel = FileList.getInstance().getModel();
                for (int i = 0; i < fileItemListModel.getSize(); i++) {
                    FileItem fileItem = fileItemListModel.getElementAt(i);
                    DeleteHandler.deleteById(fileItem.getId());
                }
                JOptionPane.showMessageDialog(
                        null,
                        "删除成功",
                        "操作提示",
                        JOptionPane.INFORMATION_MESSAGE
                );
                FileList.getInstance().flashData();
            }
        });
        this.add(button);
    }
    private void buildFlashDataButton(){
        JButton button = new JButton("刷新数据");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileList.getInstance().flashData();
                JOptionPane.showMessageDialog(
                        null,
                        "刷新成功",
                        "操作提示",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        this.add(button);
    }
    private void buildKeySettingButton(){
        JButton button = new JButton("修改API-KEY");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConfig userConfig = ConfigHandler.loadConfig();
                String apiKey = userConfig.getApiKey();
                //展示对话框
                String inputContent = JOptionPane.showInputDialog(RootComponent.frame,"当前api-key:"+apiKey+" 请输入新的api-key");
                userConfig.setApiKey(inputContent);
                ConfigHandler.saveConfig(userConfig);
            }
        });
        this.add(button);
    }
}
