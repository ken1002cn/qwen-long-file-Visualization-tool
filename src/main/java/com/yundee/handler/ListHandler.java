package com.yundee.handler;

import com.yundee.domain.FileItem;
import com.yundee.domain.ListMessage;
import com.yundee.utils.GsonUtils;
import com.yundee.utils.HttpUtils;
import java.util.List;

public class ListHandler {

    public static ListMessage listData(){
        String json = HttpUtils.list();
        return GsonUtils.fromJson(json, ListMessage.class);
    }

}
