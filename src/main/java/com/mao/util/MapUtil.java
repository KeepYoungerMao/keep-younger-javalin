package com.mao.util;

import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回体封装参数使用
 * @author mao by 14:29 2019/11/26
 */
public class MapUtil {

    /**
     * 将参数装进map中，用于封装前端返回参数
     * 参数通过aes加密，加密密钥随机生成，通过session返回
     * @param var 多个参数，需要偶数个参数
     * @param ctx Context对象
     * @return map
     */
    public static Map<String, Object> addMap(Context ctx, Object ... var){
        String aes = SU.getRandomString(16);
        ctx.sessionAttribute("aes",aes);

        Map<String, Object> map = new HashMap<>();
        int len = var.length;
        if (len%2 == 0){
            boolean isKey = true;
            String key = null;
            for (Object aVar : var) {
                if (isKey)
                    if (aVar instanceof String) key = (String) aVar;
                    else return map;
                else map.put(key, AesUtil.enCode(JsonUtil.obj2json(aVar),aes));
                isKey = !isKey;
            }
        }
        return map;
    }

}