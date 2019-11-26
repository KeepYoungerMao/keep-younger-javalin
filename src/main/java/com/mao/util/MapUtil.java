package com.mao.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mao by 14:29 2019/11/26
 */
public class MapUtil {

    public static Map<String, Object> addMap(Object ... var){
        Map<String, Object> map = new HashMap<>();
        int len = var.length;
        if (len%2 == 0){
            boolean isKey = true;
            String key = null;
            for (Object aVar : var) {
                if (isKey)
                    if (null != aVar && aVar instanceof String) key = (String) aVar;
                    else return map;
                else map.put(key, aVar);
                isKey = !isKey;
            }
        }
        return map;
    }

}