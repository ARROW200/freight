package com.scu.freight.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 8:22
 */
public class FreightUtil {
    //生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密
    public static String md5(String key){
        if (StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
