package com.yundee.utils;

import com.yundee.domain.UserConfig;
import com.yundee.handler.ConfigHandler;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

@Slf4j
public class HttpUtils {

    private static String key = "";

    private static void checkOrFetchApiKey(){
        if (key==null | key.isEmpty()){
            UserConfig userConfig = ConfigHandler.loadConfig();
            key = userConfig.getApiKey();
            if (key == null || key.isEmpty()){
                throw new RuntimeException("api-key没有配置!");
            }
        }
    }
    /**
     * 查询已上传文件列表
     * @return 响应体
     */
    public static String list(){
        checkOrFetchApiKey();
        OkHttpClient client = new OkHttpClient();
        // 创建 GET 请求
        Request request = new Request.Builder()
                .url("https://dashscope.aliyuncs.com/compatible-mode/v1/files")
                .header("Authorization","Bearer " + key)// URL 替换为实际的 API 地址
                .build();
        // 发送请求并获取响应
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return "null";
    }

    /**
     * 删除平台的文件
     * @param fid 文件id
     * @return 响应体
     * @throws IOException
     */
    public static String delete(String fid){
        checkOrFetchApiKey();
        OkHttpClient client = new OkHttpClient();
        String url = "https://dashscope.aliyuncs.com/compatible-mode/v1/files/" + fid;
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization","Bearer "+ key)
                .delete()
                .build();
        // 发送请求并获取响应
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return "null";
    }
}
