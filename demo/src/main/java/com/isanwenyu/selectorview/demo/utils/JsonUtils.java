package com.isanwenyu.selectorview.demo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * json 解析工具
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class JsonUtils {

    private static Gson mGson = new Gson();

    /**
     * 将对象准换为json字符串
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    /**
     * 将json字符串转换为对象
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json对象转换为实体对象
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json字符串转换为对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return mGson.fromJson(json, type);
    }

    /**
     * 将json字符串转换为list对象
     * @param s
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> deserializeArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }
    /**
     * 将json字符串转换为list对象
     * @param s
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> deserializeArray(String s, Type type) {
        T[] arr = new Gson().fromJson(s, type);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }





}
