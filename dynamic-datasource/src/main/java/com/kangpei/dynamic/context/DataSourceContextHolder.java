package com.kangpei.dynamic.context;

import com.kangpei.dynamic.constant.DSConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * description: DataSourceContextHolder <br>
 * date: 2020/8/18 11:02 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Slf4j
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DATA_SOURCE_CONTEXT_HOLDER = new ThreadLocal<String>();

    public static void setKey(String key) {
        DATA_SOURCE_CONTEXT_HOLDER.set(key);
    }

    public static String getKey() {

        String key = DATA_SOURCE_CONTEXT_HOLDER.get();
        return key == null ? DSConstant.MASTER : key;
    }

    public static void remove() {
        DATA_SOURCE_CONTEXT_HOLDER.remove();
    }
}
