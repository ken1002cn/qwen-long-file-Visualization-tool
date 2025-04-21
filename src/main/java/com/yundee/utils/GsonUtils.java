package com.yundee.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonUtils {
    private static final Gson gson = new Gson();

    // JSON -> Java 对象
    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    // Java 对象 -> JSON
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    // JSON -> List<T>
    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        Type type = TypeToken.getParameterized(List.class, clazz).getType();
        return gson.fromJson(json, type);
    }

    // JSON -> Map<String, Object>
    public static Map<String, Object> fromJsonToMap(String json) {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return gson.fromJson(json, type);
    }

    // JSON -> 泛型对象（高级用法）
    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }
}
