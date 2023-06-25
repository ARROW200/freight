package com.scu.freight.util;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 8:24
 */
public class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String PREFIX_USER = "user";

    //用户key
    public static String getUserKey(String uuid){
        return PREFIX_USER + SPLIT + uuid;
    }

}
