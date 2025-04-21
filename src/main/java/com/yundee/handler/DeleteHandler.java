package com.yundee.handler;

import com.yundee.domain.FileItem;
import com.yundee.domain.ListMessage;
import com.yundee.utils.GsonUtils;
import com.yundee.utils.HttpUtils;

public class DeleteHandler {

    public static void deleteAll(){
        System.out.println("------准备删除所有当前批次文件------");
        String json = HttpUtils.list();
        ListMessage listMessage = GsonUtils.fromJson(json, ListMessage.class);
        for (FileItem fileItem : listMessage.getData()) {
            System.out.println("准备删除文件:");
            String res = HttpUtils.delete(fileItem.getId());
            if (res.contains("error")){
                System.out.println("文件:" + fileItem.getId() + "删除失败,原因:" + res);
            }
            System.out.println("文件:" + fileItem.getId() + "删除成功");
        }
    }

    public static void deleteById(String id){
        System.out.println("------删除中------");
        String res = HttpUtils.delete(id);
        if (res.contains("error")){
            System.out.println("删除失败,原因:"+res);
        }
        System.out.println("删除成功");
    }
}
