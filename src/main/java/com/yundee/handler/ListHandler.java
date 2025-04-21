package com.yundee.handler;

import com.yundee.domain.FileItem;
import com.yundee.domain.ListMessage;
import com.yundee.utils.GsonUtils;
import com.yundee.utils.HttpUtils;
import java.util.List;

public class ListHandler {

    public static List<FileItem> list(){
        String json = HttpUtils.list();
        ListMessage listMessage = GsonUtils.fromJson(json, ListMessage.class);
        return listMessage.getData();
    }
}
