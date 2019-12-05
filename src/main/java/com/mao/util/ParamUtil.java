package com.mao.util;

/**
 * 参数解析
 * @author mao by 10:46 2019/12/5
 */
public class ParamUtil {

    private static final String reg = "_";

    /**
     * 获取参数
     * @param param 参数字符串
     * @return 参数数组
     */
    public static String[] getParam(String param){
        param = " "+param+" ";
        String[] split = param.split(reg);
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++)
            result[i] = split[i].trim();
        return result;
    }

    /**
     * 从Context的pathParam中获取int参数
     * 默认获取不到返回0
     * @param s param
     * @return int param
     */
    public static int getInt(String s){
        return getInt(s,0);
    }

    /**
     * 从Context的pathParam中获取int参数
     * 自己设置默认值
     * @param s param
     * @param def 默认值
     * @return int param
     */
    public static int getInt(String s, int def){
        int id = def;
        try {
            id = Integer.parseInt(s);
        } catch (NumberFormatException ignored) {}
        return id;
    }

}