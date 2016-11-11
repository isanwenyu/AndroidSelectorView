package com.isanwenyu.selectorview.demo.utils;

import android.text.TextUtils;

import java.util.List;

/**
 * <pre>
 * 简单工具类
 * Created by isanwenyu on 2016/11/8.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class Utils {
    /**
     * 判断list是否有数据
     *
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNullList(List list) {
        if (list != null && list.size() > 0) {
            return false;
        }
        return true;
    }
    /**
     * 判断是不空字符串包括“null”
     *
     * @param str
     * @return
     */
    public static boolean isNullStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        } else if ("null".equals(str.trim().toLowerCase())) {
            return true;
        }
        return false;
    }


}
